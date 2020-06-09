import { Component, Input } from "@angular/core";


@Component({
    selector :'app-profile',
    template : `
       <h1>{{title}}</h1>
    `
})
export class ProfileComponent{

    @Input()
    title:string;

}