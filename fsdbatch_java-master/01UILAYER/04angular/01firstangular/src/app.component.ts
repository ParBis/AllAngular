import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'my-app',
    template: `
        <div>Our first component</div>
        <my-badge></my-badge>
    `
})
export class AppComponent implements OnInit {

    constructor() { }

    ngOnInit() { 

    }

}