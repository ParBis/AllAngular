import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';


@Component({
    selector: 'my-badge',
    templateUrl: 'badge.component.html'
})
export class BadgeComponent implements OnInit {

    @Input('caption') caption: string = "Default Caption"
    @Input('intialcount') count: number = 1

    @Output('whenBadgeClicked') clicked : EventEmitter<string> = new EventEmitter<string>();

    incrementCount(){
        console.log('Here i want to increment the count')
        this.count = this.count+1
        this.clicked.emit('' + this.count)
    }

    constructor() { }

    ngOnInit() { 

    }

}