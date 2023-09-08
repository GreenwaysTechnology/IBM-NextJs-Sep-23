import { ApolloServer } from "@apollo/server"
import { startStandaloneServer } from '@apollo/server/standalone'

//Define schema 
const typeDefs = `

#Hello api

type Query{
    #apiName:ReturnType
    hello:String
    hai:String
}


`

//Biz logic : implement api : Resolver
const resolvers = {
    //api implementation : Query,Mutation,Subscription
    Query: {
        //write query operations
        hello() {
            return 'Hello Apollo Graphql'
        },
        hai(){
            return "Hai Apollo GraphQl"
        }
    }

}

//Deploy 
//3.We need to deploy the schema and bind with resolver 
const server = new ApolloServer({
    typeDefs: typeDefs,
    resolvers: resolvers
})
//4.Start web server (Express.js)
const { url } = await startStandaloneServer(server, {
    listen: {
        port: 4000
    }
})
console.log(`Apollo Server is Ready ${url}`)