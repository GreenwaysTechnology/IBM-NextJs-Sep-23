import { NextResponse } from "next/server"
//API 
export async function GET(request) {
    //
     //send response
     return NextResponse.json({ message: 'welcome to api' })
}