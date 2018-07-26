import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-root',
    template: `
        <h1>This is the outermost component</h1>
        <hr/>
       <my-dropdown></my-dropdown>

       <hr/>

       <my-todo></my-todo>
    `
})
export class OuterComponent implements OnInit {

    constructor() { }

    ngOnInit() { 

    }

}