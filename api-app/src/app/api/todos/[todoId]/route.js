import { NextResponse } from "next/server"
//API 
export async function GET(request) {
      //send response
     return NextResponse.json({ message: 'Todos Api by id' })
}

//DELETE BY ID 
//DELETE REQUEST
export  async function DELETE(request) {
    //send response
    return NextResponse.json({ message: 'TODOS API BY ID  DELETE' })
}
//UPDATE BY ID //PUT
export  async function PUT(request) {
    //send response
    return NextResponse.json({ message: 'TODOS API BY ID  PUT' })
}

