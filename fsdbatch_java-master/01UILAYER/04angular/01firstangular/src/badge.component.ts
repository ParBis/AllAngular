import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'my-badge',
    template: `
    <button class="btn btn-primary" type="button">
        Messages <span class="badge">4</span>
    </button>
    `
})
export class BadgeComponent implements OnInit {

    constructor() { }

    ngOnInit() { 

    }

}