// "use client";

import { useState } from "react"

//client component
export default function Like() {
    const [count, setCount] = useState(10)
    return <>
        <h1>Like {count}</h1>
        <button onClick={() => {
            setCount(count + 1)
        }}>+</button>
    </>
}