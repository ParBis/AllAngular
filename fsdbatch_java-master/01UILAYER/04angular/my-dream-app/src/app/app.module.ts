import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { StorageServiceModule } from 'angular-webstorage-service';

import { AppComponent } from './app.component';
import { MyBadgeComponent } from './feature/my-badge/my-badge.component';
import {BadgeComponent} from './components/badge.component'
import { OuterComponent } from './outer.component';
import {ParentComponent} from './components/parent.component'
import {ChildComponent} from './components/child.component'
import {DropdownComponent} from './dropdown/dropdown.component'
import { ButtonComponent } from './dropdown/button.component';
import { ListItemComponent } from './dropdown/listitem.component';
import {TodoComponent} from './todo/todo.component'

@NgModule({
  declarations: [
    AppComponent,
    MyBadgeComponent,
    BadgeComponent,
    OuterComponent,
    ParentComponent,
    ChildComponent,
    DropdownComponent,
    ButtonComponent,
    ListItemComponent,
    TodoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    StorageServiceModule
  ],
  providers: [],
  bootstrap: [OuterComponent]
})
export class AppModule { }
