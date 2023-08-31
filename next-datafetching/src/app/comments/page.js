import Link from "next/link"

//api 
async function getComments() {
    const url = `https://jsonplaceholder.typicode.com/comments`
    const response = await fetch(url)
    console.log('fetching...')
    return response.json()
}

export default async function CommentsPage() {
    const comments = await getComments()
    return <ul>
        {comments.map(comment => {
            return <>
                <li>
                   <Link href={`/comments/${comment.id}`}>{comment.name}</Link>
                </li>

            </>
        })}
    </ul>
}