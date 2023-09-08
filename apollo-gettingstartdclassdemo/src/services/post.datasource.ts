import { RESTDataSource } from "@apollo/datasource-rest";


interface Post {
    userId: number
    id: number
    title: string
    body: string
}


//This datasource class talks to third party rest api
//
export class PostDataSource extends RESTDataSource {
    constructor() {
        super()
        this.baseURL = "https://jsonplaceholder.typicode.com"
    }
    async findAll() {
        return this.get<Post[]>('/posts')
    }
    async findById(id: number) {
        return this.get<Post>(`/posts/${id}`)
    }
    //save
    async save(post: Post) {
        return this.post<Post>(`posts`, { body: post }).then(res => res)
    }
    //update 
    async update(id: number, post: Post) {
        return this.put<Post>(`posts/${id}`, { body: post }).then(res => res)
    }

}