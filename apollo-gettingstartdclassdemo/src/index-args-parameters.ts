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
  users:[User]    
  user(id:ID):User
}


`

const USERS = [{
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
},
{
    id: 2,
    firstName: 'Ram',
    lastName: 'Murugan',
    status: true,
    points: 198.8,
    address: {
        city: 'Chennai',
        state: 'TN'
    },
    age: 35
},
{
    id: 3,
    firstName: 'Geetha',
    lastName: 'Subramanian',
    status: true,
    points: 198.8,
    address: {
        city: 'Banaglore',
        state: 'KA'
    },
    age: 40
}
]

//Biz logic : implement api : Resolver
const resolvers = {
    //api implementation : Query,Mutation,Subscription
    Query: {
        users() {
            return USERS
        },
        user(parent, args, ctx, info) {
            //args hold literal object args = {id:1}=>args.id
            return USERS.find(user => {
                return user.id === +args.id
            })

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