import { ApolloServer } from "@apollo/server"
import { startStandaloneServer } from '@apollo/server/standalone'

//Define schema 
const typeDefs = `

type Query{
  hello(name:String):String
}

`
//Biz logic : implement api : Resolver
const resolvers = {
    Query: {
        hello(parent, args, context, info) {
            return `${context.greet} ${args.name}`
        }
    }

}

//Define Context type
interface AppContext {
    greet: string
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
            greet: 'Welcome' //to be shared  across app
        }
    }

})
console.log(`Apollo Server is Ready ${url}`)