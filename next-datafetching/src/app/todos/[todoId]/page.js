
//api 
async function getTodosById(id) {
    const url = `https://jsonplaceholder.typicode.com/todos/${id}`
    const response = await fetch(url)
    console.log('fetching...')
    return response.json()
}


export default async function TodosPage(props) {
    const todo = await getTodosById(+props.params.todoId)
    return <>
        <div>
            <h1> id : {todo.id}</h1>
            <h2> title: {todo.title}</h2>
            <h2>Status : {todo.status ? "completed" : "not completed"}</h2>

        </div>
    </>
}