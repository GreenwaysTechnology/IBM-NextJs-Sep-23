import { ApolloServer } from "@apollo/server"
import { startStandaloneServer } from '@apollo/server/standalone'
import { UserDataSource } from "./services/user.datasource.js"
import { readFileSync } from "fs";

const typeDefs = readFileSync("./schema.graphql", { encoding: 'utf-8' })

//Biz logic : implement api : Resolver
const resolvers = {
    Query: {
        users(parent,args,context,info){
            return context.dataSources.usersAPI.findAll()
        }
    },
  

}

//Define Context type
interface AppContext {
    dataSources: {
        usersAPI: UserDataSource
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
                usersAPI: new UserDataSource()
            }
        }
    }

})
console.log(`Apollo Server is Ready ${url}`)