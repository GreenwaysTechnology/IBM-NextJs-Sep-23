export default function PanelLayout(props) {
    const isAdmin = false 
    return <div>
         {props.children}
         {isAdmin ? props.AdminPanel : props.UserPanel}
    </div>
}