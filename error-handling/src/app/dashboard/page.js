export default function DashboardPage() {
    const isAdmin = true
    if (isAdmin) {
        return <>
            <h1>DashBoard Page</h1>
        </>
    } else {
        throw 'You are not Admin'
    }
}