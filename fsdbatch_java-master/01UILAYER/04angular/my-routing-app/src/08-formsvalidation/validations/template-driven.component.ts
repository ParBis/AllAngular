import { Component } from '@angular/core';
import { NgForm } from "@angular/forms";
import { LogService } from '../services/log.service';

@Component({
  selector: 'template-driven',
  templateUrl: './template-driven.component.html',
  styles: [`
    .ng-invalid {
      border: 1px solid red;
    }
  `]
//   providers: [LogService]
})
export class TemplateDrivenComponent {

    logs: Array<string>;
    constructor(private logService: LogService){

    }

    getLogs(){
        this.logs = this.logService.fetchLogs();
    }

  user = {
    username: 'Puneet',
    email: 'test@test.com',
    password: 'test',
    gender: 'male'
  };

  genders = [
    'male',
    'female'
  ];

  onSubmit(form: NgForm) {

    console.log(form.value);
    console.log(this.user);
    this.logService.log(this.user.username);
  }
}
