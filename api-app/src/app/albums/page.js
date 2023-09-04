import { Suspense } from "react"

async function getAlbums() {
   // const url = `http://localhost:3000/api/albums`
   const url = `${process.env.HOST}/api/albums`
    
    const res = await fetch(url)
    if (!res.ok) {
        throw new Error('data is not available')
    }
    return res.json()
}
function Loading() {
    // You can add any UI inside Loading, including a Skeleton.
    return <h2>🌀 Loading...</h2>;
}
export default async function AlbumsPage() {

    const albums = await getAlbums()
    return <div>
        <h1>Albums Page</h1>
        {/* enables streaming */}
        <Suspense fallback={<Loading/>}>
            <ul>
                {albums.map(album => {
                    return <li>{album.title}</li>
                })}
            </ul>
        </Suspense>
    </div>
}