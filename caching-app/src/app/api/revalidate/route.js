
import { NextRequest, NextResponse } from 'next/server';
import { revalidatePath, revalidateTag } from 'next/cache';

export async function GET(request) {
    const path = request.nextUrl.searchParams.get('path') || '/timecache/[city]';
    const collection =
        request.nextUrl.searchParams.get('collection') || 'collection';
    revalidatePath(path);
    revalidateTag(collection);
    console.log('revalidated', path, collection);
    // console.log('revalidated', path);
    return NextResponse.json({
        revalidated: true,
        now: Date.now(),
        cache: 'no-store',
    });
}