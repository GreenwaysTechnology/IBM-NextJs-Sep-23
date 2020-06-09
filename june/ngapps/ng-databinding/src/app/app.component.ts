import { Component } from "@angular/core";

/**
 * Interpolation
 */

//controller
@Component({
  selector : 'app-root', //custom element name
  templateUrl:'app.component.html' //template---view
})
export class AppComponent{
  
  //data
   title:string='IBM -Angular Application'
   name:string = 'Subramanian'
   age:number =39;
   isActive:boolean = true;

   //objects //todo object
   todo = {
    userId: 1,
    id: 1,
    title: "delectus aut autem",
    completed: false
  }
   

}

