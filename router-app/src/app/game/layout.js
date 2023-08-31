export default function GameLayout(props) {
    return <div id="gamelayout">
        {/* Game Page  */}
        {props.children}
        <hr />
        {/* Team Page */}
        {/* props.folderName : props.@team  */}
        {props.team}
        {/* Analytics Page */}
        <hr/>
        {props.anaylitics}
    </div>
}