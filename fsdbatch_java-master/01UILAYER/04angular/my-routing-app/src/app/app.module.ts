import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {Routes, RouterModule} from '@angular/router'
 import { AppComponent } from './app.component';
 import {HomeComponent} from './home/home.component'
import { AboutComponent } from './about/about.component';

const routes: Routes = [
  { path: '' , component: HomeComponent},
  { path: 'about/:city' , component: AboutComponent}

]

@NgModule({
  declarations: [
    AppComponent, HomeComponent, AboutComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
