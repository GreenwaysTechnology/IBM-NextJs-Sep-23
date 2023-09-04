'use client';

import useSWR from 'swr'

function fetcher(...args) {
    return fetch(...args).then(res => res.json())
}

export const Albums = () => {
    const url = 'https://jsonplaceholder.typicode.com/albums'
    const { data, error, isLoading } = useSWR(url, fetcher)
    if (isLoading) return <p>Loading...</p>
    if (error) return <p>No Album data</p>

    return (
        <div>
            {data.map(album => {
                return <h2 key={album.id}>{album.title}</h2>
            })}
        </div>
    )
}