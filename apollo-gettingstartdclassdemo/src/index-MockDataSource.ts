import { ApolloServer } from "@apollo/server"
import { startStandaloneServer } from '@apollo/server/standalone'
// import { COMMENTS } from "./mock-data/comments.js"
import { CommentsDataSource } from "./services/comments.datasource.js"

//Define schema 
const typeDefs = `
type Comment {
    postId:Int
    id:ID
    name:String
    email:String
    body:String
}
type Query{
    comments:[Comment!]!
    comment(id:ID!):Comment
}

input CommentCreateInput{
    postId:Int
    id:ID
    name:String
    email:String
    body:String
}
input CommentUpdateInput{
    postId:Int
    id:ID
    name:String
    email:String
    body:String
}
type Mutation {
    addComment(comment:CommentCreateInput):Comment
    updateComment(id:ID!,comment:CommentUpdateInput!):Comment
    removeComment(id:ID!):Boolean
}

`
//Biz logic : implement api : Resolver
const resolvers = {
    Query: {
        comments(parent, args, context, info) {
            return context.dataSources.commentsAPI.findAll()
        },
        comment(parent, args, context, info) {
            return context.dataSources.commentsAPI.findById(+args.id)
        }
    },
    Mutation: {
        addComment(parent, args, context, info) {
            return context.dataSources.commentsAPI.save(args.comment)
        },
        updateComment(parent,args,context,info){
            return context.dataSources.commentsAPI.update(+args.id,args.comment)
        }

    }

}

//Define Context type
interface AppContext {
    dataSources: {
        commentsAPI: CommentsDataSource
    }

}


//Deploy 
//3.We need to deploy the schema and bind with resolver 
const server = new ApolloServer<AppContext>({
    typeDefs: typeDefs,
    resolvers: resolvers
})
//4.Start web server (Express.js)
const { url } = await startStandaloneServer(server, {
    listen: {
        port: 4000
    },
    context: async () => {
        //must return context object
        return {
            dataSources: {
                commentsAPI: new CommentsDataSource()
            }
        }
    }

})
console.log(`Apollo Server is Ready ${url}`)