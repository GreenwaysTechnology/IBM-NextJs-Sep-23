import Link from "next/link"
export default function DashboardLayout(props) {
    return <>
        <hr />
        <nav>
            <Link href="/dashboard/settings">Settings</Link>
        </nav>
        {props.children}
    </>
}