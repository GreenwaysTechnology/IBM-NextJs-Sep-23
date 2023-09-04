import styles from './dashboard.module.css'

export default function DashBoardLayout({ children }) {
    return <div className={styles.box}>
        {children}
    </div>
}