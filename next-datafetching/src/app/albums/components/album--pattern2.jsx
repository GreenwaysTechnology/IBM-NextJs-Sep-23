'use client';
import { useState, useEffect } from 'react'

export const Albums = () => {
    const [data, setData] = useState(null)
    const [isLoading, setLoading] = useState(true)

    useEffect(() => {
        fetch('https://jsonplaceholder.typicode.com/albums')
            .then((res) => res.json())
            .then((data) => {
                setData(data)
                setLoading(false)
            })
    }, [])

    if (isLoading) return <p>Loading...</p>
    if (!data) return <p>No Album data</p>

    return (
        <div>
            {data.map(album => {
                return <h2 key={album.id}>{album.title}</h2>
            })}
        </div>
    )
}