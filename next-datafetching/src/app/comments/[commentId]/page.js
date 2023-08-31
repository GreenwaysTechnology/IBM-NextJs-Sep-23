

export default function CommentsDetailsPage(props) {

    return <>
        <h1>Comments Details page</h1>
    </>
}

async function getComments() {
    const url = `https://jsonplaceholder.typicode.com/comments`
    const response = await fetch(url)
    console.log('fetching...')
    return response.json()
}

//build page during build time 
export async function generateStaticParams() {
    console.log('building')
    const comments = await getComments()
    return comments.map(comment => {
        let id = comment.id.toString()
        return {
            commentId: id
        }
    })
}    