export default async function AlbumPage(props) {
    // const url = 'http://localhost:3000/api/albums'
    const url = `${process.env.ALBUM_LOCAL_HOST}/albums`

    const res = await fetch(url, { next: { revalidate: 60 } })

    const albums = await res.json();
    return <div style={{ marginLeft: 50 }}>
        <ul>
            {albums.map(album => {
                return <li>{album.title}</li>
            })}
        </ul>
    </div>
}