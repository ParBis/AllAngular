import { Component, OnInit } from '@angular/core';
import {LogService} from '../services/log.service'

@Component({
    selector: 'simple',
    template : `
        <h2>Simple component to display logs</h2>
        <button (click)="getLogs()"> Display Logs</button>

    <ul>
        <li *ngFor="let log of logs">{{log}}</li>
    </ul>
    `
    // providers: [LogService]
})
export class SimpleComponent implements OnInit {

    logs: Array<string>;
    constructor(private logService: LogService) { }

    ngOnInit() { 
       
    }
    getLogs(){
        this.logs = this.logService.fetchLogs();
    }


}