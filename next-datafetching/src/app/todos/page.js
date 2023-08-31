import Link from "next/link"

//api 
async function getTodos() {
    const url = `https://jsonplaceholder.typicode.com/todos`
    const response = await fetch(url)
    console.log('fetching...')
    return response.json()
}

export default async function TodosPage() {
    const todos = await getTodos()
    return <ul>
        {todos.map(todo => {
            return <>
                <li>
                   <Link href={`/todos/${todo.id}`}>{todo.title}</Link>
                </li>

            </>
        })}
    </ul>
}