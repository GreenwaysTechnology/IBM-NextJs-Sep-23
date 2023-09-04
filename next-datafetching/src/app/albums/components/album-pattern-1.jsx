'use client';

async function getAlbums() {
    const url = `https://jsonplaceholder.typicode.com/albums`
    const res = await fetch(url)
    if (!res.ok) {
        throw new Error('data is not available')
    }
    return res.json()
}
export default async function Album() {
    const albums = await getAlbums()
    return <div>
        <h1>Album</h1>
        <div>
            {albums.map(album => {
                return <h2 key={album.id}>{album.title}</h2>
            })}
        </div>
    </div>
}