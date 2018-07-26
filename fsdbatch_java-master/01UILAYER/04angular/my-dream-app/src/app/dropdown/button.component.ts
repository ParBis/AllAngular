import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
    selector: 'my-button',
    template: `
    <button (click)= "onClickHandle()" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      {{buttonCaption}}
    </button>
    `
})
export class ButtonComponent implements OnInit {

    @Input('buttonCaption') buttonCaption :string = ''
    @Output('whenButtonClicked') whenButtonClicked : EventEmitter<any> = new EventEmitter();
    constructor() { }

    onClickHandle(){
        this.whenButtonClicked.emit();
    }

    ngOnInit() { 

    }

}