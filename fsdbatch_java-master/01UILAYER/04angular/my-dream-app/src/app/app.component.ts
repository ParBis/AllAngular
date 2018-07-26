import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ChangedValue';
  initCount: number = 23;
  sentCount: string = "";

  onClicked(value: string) {
    console.log('Recieved value', value);
    this.sentCount = value;
}
}
