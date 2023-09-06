import { PrismaClient } from "@prisma/client";

const prisma = new PrismaClient();

/**
 * The term upsert is a portmanteau – a combination of the words “update” and “insert.” In the context of relational databases, an upsert is a database operation that will update an existing row if a specified value already exists in a table, and insert a new row if the specified value doesn't already exist
 */
async function main() {
    const user = await prisma.user.upsert({
        where: { email: "admin@admin.com" },
        update: {},
        create: {
            name: "Admin",
            email: "admin@admin.com",
            role: "admin",
        },
    });

    console.log({ user });
}
main()
    .then(() => prisma.$disconnect())
    .catch(async (e) => {
        console.error(e);
        await prisma.$disconnect();
        process.exit();
    });
