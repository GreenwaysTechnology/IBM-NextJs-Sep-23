
export default function TodosDetailsPage(props) {
    console.log(props)
    return <>
        <h1>Todos Details Page</h1>
        <h2>Id: {props.params.todoId}</h2>
    </>
}