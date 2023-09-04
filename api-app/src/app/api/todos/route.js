import { NextResponse } from "next/server"
//API 
export async function GET(request) {
      //send response
     return NextResponse.json({ message: 'Todos Api' })
}
//post
export  async function POST(request) {
    //send response
    return NextResponse.json({ message: 'TODOS POST' })
}