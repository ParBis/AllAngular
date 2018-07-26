import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'my-toggle',
    template: `
        <button (click)="clicked()">Toggle</button>
        <p>{{message}}</p>
    `
})
export class ToggleComponent implements OnInit {

    constructor() { }

    flag : boolean = false;
    message: string = ''

    ngOnInit() { 

    }

    clicked(){
        console.log('clicked');
        this.flag = !this.flag
        this.message = `Toggle is ${this.flag}`

    }

}