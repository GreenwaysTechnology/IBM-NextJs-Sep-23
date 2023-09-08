import { getClient } from "../../lib/client";
import { gql } from "@apollo/client";

//Query creation using "gql function from the Apollo Client"
const query = gql`query Users {
    users {
          id
          name
          email
    }      
}`
export default async function Page() {
  //calling graqhl api 
  const { data: { users } } = await getClient().query({ query });
  return <main>
    <ul>
      {users.map(user => {
        return <li>{user.id} - {'Name'} - {user.name} {'Email'} -{user.email} </li>
      })}
    </ul>
  </main>
}