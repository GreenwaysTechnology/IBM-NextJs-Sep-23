import { ApolloServer } from "@apollo/server"
import { startStandaloneServer } from '@apollo/server/standalone'
import { PostDataSource } from "./services/post.datasource.js"

//Define schema 
const typeDefs = `

type Post{
    userId:Int
    id: ID
    title: String
    body: String
}

type Query {
    posts:[Post!]!
    post(id:ID!):Post
}
input PostCreateInput {
    title:String
    body:String
}
type Mutation {
    addPost(post:PostCreateInput):Post
}

`
//Biz logic : implement api : Resolver
const resolvers = {
    Query: {
        posts(parent, args, context, info) {
            return context.dataSources.postsAPI.findAll()
        },
        post(parent, args, context, info) {
            return context.dataSources.postsAPI.findById(+args.id)
        }
    },
    Mutation :{
        addPost(parent,args,context,info){
            return context.dataSources.postsAPI.save(args.post)

        }
    }

}

//Define Context type
interface AppContext {
    dataSources: {
        postsAPI: PostDataSource
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
                postsAPI: new PostDataSource()
            }
        }
    }

})
console.log(`Apollo Server is Ready ${url}`)