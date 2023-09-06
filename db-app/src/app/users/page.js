export const revalidate = 10
export default async function TodoPage() {
    const response = await fetch('http://localhost:3000/api/users')
    const users = await response.json()
    return <>
        <h1>Users Page</h1>
        <ul>
            {
                users.map(user => {
                    return <li>{user.id} - {user.name} - {user.email}</li>
                })
            }
        </ul>
    </>
}