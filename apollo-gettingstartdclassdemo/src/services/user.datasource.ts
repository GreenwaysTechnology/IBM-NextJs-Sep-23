import { prisma } from '../lib/prisma.js'

export class UserDataSource {
    constructor() {

    }
    async findAll() {
        return await prisma.user.findMany({})
    }
}