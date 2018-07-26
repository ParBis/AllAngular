import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'my-dropdown',
    template: `
    <div class="dropdown">
    <my-button [buttonCaption]="buttonCaption" (whenButtonClicked)="toggleShow($event)"></my-button>
    <my-listitem [courses]="courses" [listClass]="listClass" (whenItemClicked)="selectCourse($event)"></my-listitem>
  </div>
    `
})
export class DropdownComponent implements OnInit {
    buttonCaption: string = "Select Course!!"
    show : boolean  = false;
    listClass = "dropdown-menu"
    courses: Array<string> = ["Angular", "React", "Ember"]

    constructor() { }

    ngOnInit() { 

    }

    selectCourse(course:string){
        console.log('selecting a course... in the parent', course);
        this.buttonCaption = course;
        this.toggleShow();
    }

    toggleShow(){
        console.log('toggle!!')
        this.show = !this.show
        if(this.show){
            this.listClass = "dropdown-menu show"
        }else{
            this.listClass = "dropdown-menu"
        }
       
    }

}