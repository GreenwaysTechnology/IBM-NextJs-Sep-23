
//ISR  = SSG + revalidation

export const revalidate = 5
export default async function CachePage(props) {
    // const response = await fetch('http://worldtimeapi.org/api/timezone/Asia/Kolkata',{ next: { revalidate: 10 }})
    // const response = await fetch('http://worldtimeapi.org/api/timezone/Asia/Kolkata')
    const response = await fetch(`http://worldtimeapi.org/api/timezone/Asia/${props.params.city}`);

    const data = await response.json();
    return <>
        <h1>Time Now : {new Date(data.datetime).toLocaleTimeString()} </h1>
        <h1>ISR Details page {JSON.stringify(props)}</h1>
    </>
}
export async function generateStaticParams() {
    return [{ city: 'Kolkata' }];
}