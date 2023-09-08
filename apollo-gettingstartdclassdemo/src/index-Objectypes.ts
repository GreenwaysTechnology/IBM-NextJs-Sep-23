import { ApolloServer } from "@apollo/server"
import { startStandaloneServer } from '@apollo/server/standalone'

//Define schema 
const typeDefs = `

type Address {
    city:String
    state:String
}

type User {
    id:ID,
    firstName:String
    lastName:String
    status:Boolean
    points:Float
    age:Int
    address:Address
}

type Query {
  user:User    
}


`

//Biz logic : implement api : Resolver
const resolvers = {
    //api implementation : Query,Mutation,Subscription
    Query: {
        user() {
            return {
                id: 1,
                firstName: 'Subramanian',
                lastName: 'Murugan',
                status: true,
                points: 198.8,
                address: {
                    city: 'Coimbatore',
                    state: 'TN'
                },
                age: 43
            }
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