import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
    selector: 'my-listitem',
    template: `
    <div class={{listClass}} aria-labelledby="dropdownMenuButton">
        <a class="dropdown-item" *ngFor="let course of courses" (click)="onClickHandle(course)" href="#" >{{course}}</a>
    </div>
    `
})
export class ListItemComponent implements OnInit {

    @Input('courses') courses : Array<string> = [];
    @Input('listClass') listClass: string = "dropdown-menu"
    @Output('whenItemClicked') whenItemClicked : EventEmitter<string> = new EventEmitter();

    constructor() { }

    onClickHandle(course: string){
        this.whenItemClicked.emit(course)
    }

    ngOnInit() { 

    }

}