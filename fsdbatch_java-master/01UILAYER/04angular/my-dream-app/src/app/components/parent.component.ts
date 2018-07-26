import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'parent-component',
    template: `
        <h2>Parent Component</h2>

        <p>From the child: {{countryName}}</p>
        <input #name (change)="0" type="text" placeholder="Enter name"/>
        {{name.value}}
        <hr/>
        <child-component [caption]="name.value" (countryChanged)="onCountryChanged($event)">

    `
})
export class ParentComponent implements OnInit {

    countryName: string = ""
    constructor() { }

    onCountryChanged(countryName: string){
        console.log('In parent' , countryName)
        this.countryName = countryName;
    }

    ngOnInit() { 

    }

}