import { prisma } from "@/lib/prisma";
import { NextResponse } from "next/server";

export async function GET(request, { params }) {
    const id = params.id;
    console.log(id)
    const user = await prisma.user.findUnique({
        where: {
            id,
        },
    });
    if (!user) {
        return new NextResponse("No user with ID found", { status: 404 });
    }
    return NextResponse.json(user);
}
export async function PATCH(request, { params }) {
    const id = params.id;
    let json = await request.json();
    const updated_user = await prisma.user.update({
        where: { id },
        data: json,
    });
    if (!updated_user) {
        return new NextResponse("No user with ID found", { status: 404 });
    }
    return NextResponse.json(updated_user);
}
export async function DELETE(request, { params }) {
    try {
        const id = params.id;
        await prisma.user.delete({
            where: { id },
        });
        return new NextResponse(null, { status: 204 });
    }
    catch (error) {
        if (error.code === "P2025") {
            return new NextResponse("No user with ID found", { status: 404 });
        }
        return new NextResponse(error.message, { status: 500 });
    }
}
