
//override meta data options
export const metadata = {
    title: 'IBM-Dashboard',
    description: 'This is dashboard',
}

export default function DashboardLayout({ children }) {
    return (
        <div>
            {children}
        </div>
    )
}