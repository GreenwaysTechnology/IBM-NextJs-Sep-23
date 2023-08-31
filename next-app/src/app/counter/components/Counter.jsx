"use client"
import { useState } from "react"

export const Counter = props => {
    //hooks
    const [counter, setCounter] = useState(0)

    //listener
    const onIncrement = () => {
        setCounter(counter + 1)
    }
    return <>
        <h1>Counter {counter} </h1>
        <button onClick={onIncrement}>+</button>
    </>

}