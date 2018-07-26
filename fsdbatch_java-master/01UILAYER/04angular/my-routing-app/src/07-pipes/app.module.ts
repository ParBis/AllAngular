import { NgModule } from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ReversePipe } from './reverse.pipe';
import { CapitalizePipe } from './capitalize.pipe';


@NgModule({
  imports: [ BrowserModule, HttpModule, FormsModule ],
  declarations: [ AppComponent, ReversePipe, CapitalizePipe ],
  bootstrap: [ AppComponent ]
})

export class AppModule { }
