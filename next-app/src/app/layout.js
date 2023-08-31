






//create a component 
export default function RootLayout({ children }) {
  return (<html lang="en">
    <body>
      <header>
        <h2>Header</h2>
      </header>
      {children}
      <div>
        <h2>Footer</h2>
      </div>
    </body>
  </html>
  )
}