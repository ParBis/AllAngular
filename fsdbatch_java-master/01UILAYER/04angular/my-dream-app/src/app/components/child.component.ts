import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
    selector: 'child-component',
    template: `
        <h2>Child Component</h2>
        <p>From the parent: {{caption}}</p>

        <div>
            <input #country (change)="handleChange()" type="text" placeholder="Enter name"/>
            {{country.value}}  
        </div>

    `
})
export class ChildComponent implements OnInit {

    @Input('caption') caption: string = ""
    @Output('countryChanged') countryChanged: EventEmitter<string> = new EventEmitter();
    constructor() { }

    handleChange(){
        console.log('handleChange');
        this.countryChanged.emit('India');
    }

    ngOnInit() { 

    }



}