import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

@Component({
    selector: 'my-app',
    template:`
        <div>
            <h3>{{name | uppercase}}</h3>
            <h3>{{"onSET of Monsoon in INdia!!" | captialize:5}}</h3>
            <h3>{{name | reverse | uppercase}}</h3>
            <h3>{{today | date}}</h3>
            <h3>{{today | date:'dd MMM yy hh:mm:ss a'}}</h3>

            <ul>
                <li *ngFor="let user of users">{{user.name | reverse}}</li>
            </ul>

            <hr/>
            <button (click)="reverse()">Reverse The Name</button>
        </div>

    `
})
export class AppComponent implements OnInit {

    users: Array<any>;
    name: string = "Ravi Kumar"
    today: Date = new Date()

    // Use the method in component for template manipulations
    reverse(){
        // get this from the server, server does the reverse of string
        this.name = this.name.split('').reverse().join('');
    }

    constructor(private http: Http) { }

    ngOnInit() { 
        this.http.get('http://localhost:7000/users')
        .toPromise()
        .then((res) => res.json())
        .then((response)=> {
            console.log(response)
            this.users = response.data;
        })
    }

}