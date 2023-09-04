export default function DashboardLayout(props) {
    let isEnabled = false 
    if(!isEnabled){
        throw new "Layout error"
    }
    return <>
        {props.children}
    </>
}