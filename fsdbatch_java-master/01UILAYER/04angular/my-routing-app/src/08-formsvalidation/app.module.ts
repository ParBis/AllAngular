import { NgModule } from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { DataDrivenComponent } from './validations/data-driven.component';
import { TemplateDrivenComponent } from './validations/template-driven.component';
import { SimpleComponent } from './validations/simple.component';
import { LogService } from './services/log.service';
import { ToggleComponent } from './components/toggle.component';



@NgModule({
  imports: [ BrowserModule, HttpModule,ReactiveFormsModule , FormsModule ],
  declarations: [ AppComponent, DataDrivenComponent, TemplateDrivenComponent, SimpleComponent, ToggleComponent ],
  bootstrap: [ AppComponent ],
  providers: [LogService]
})

export class AppModule { }
