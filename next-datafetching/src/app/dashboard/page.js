
import React, { Suspense } from 'react';

const Welcome = React.lazy(() => {
    return new Promise((resolve, reject) => {
        //lazy loading component: here greeter to be loaded async , meaning that this component to be available only after 8000 ms,
        //during 8000 ms  , we need to show some Spinner,thats where loading.js code 
        //to be used
        setTimeout(resolve, 8000, import('./greeter'))
    })
});


export default function DashboardPage() {
    return <div>
        <h1>Loader and Suspense</h1>
        {/* <Welcome/> */}
        <Suspense fallback={<h1>Loading....</h1>}>
            <Welcome/>
        </Suspense>
        {/* <Suspense fallback={<h1>Loading....</h1>}>
            <Welcome/>
        </Suspense> */}
        <h2>footer</h2>
    </div>
}