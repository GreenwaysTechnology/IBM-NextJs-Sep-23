import { NextResponse } from "next/server";

export async function GET(request) {
    //logic 
    return NextResponse.json({ page: 'Home' })
}