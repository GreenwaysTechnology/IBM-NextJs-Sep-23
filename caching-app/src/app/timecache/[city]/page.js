
//segment config
export const revalidate = 15

export default async function ISRDetails(props) {

    //cached
    // const response = await fetch(`http://worldtimeapi.org/api/timezone/Asia/${props.params.city}`);

    //no cache
    // const response = await fetch(`http://worldtimeapi.org/api/timezone/Asia/${props.params.city}`, { cache: 'no-store' });

    //cache + revalidation : time based 
    // const response = await fetch(`http://worldtimeapi.org/api/timezone/Asia/${props.params.city}`,{ next: { revalidate: 2 } });

    const response = await fetch(`http://worldtimeapi.org/api/timezone/Asia/${props.params.city}`);

    const data = await response.json();
    return <>
        {/* <h1>ISR Details page {JSON.stringify(props)}</h1> */}
        <h1>Time now :{new Date(data.datetime).toLocaleTimeString()} </h1>
        {/* <h1>{data.datetime}</h1> */}
    </>

}

//prepare SSG 
export async function generateStaticParams() {

    return [{ city: 'Kolkata' }];
}