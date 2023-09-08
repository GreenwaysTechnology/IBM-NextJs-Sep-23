import { COMMENTS } from "../mock-data/comments.js";


export class CommentsDataSource {
    constructor() { }
    //apis
    findAll() {
        return COMMENTS
    }
    findById(id: number) {
        return COMMENTS.find(comment => {
            return comment.id === id
        })
    }
    //add
    save(comment) {
        COMMENTS.push(comment)
        return comment
    }
    //update
    update(id: number, comment) {
        //write logic to update an array with element
        return comment
    }
    //delete
    remove(id: number) {
        //write logic to remove an item from array
        return true;
    }
}