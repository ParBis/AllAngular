import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {Routes, RouterModule} from '@angular/router'
import { AppComponent } from './app.component';
import {HomeComponent} from './home/home.component';
import {AboutComponent} from './about/about.component';
import { HttpClientModule } from '@angular/common/http';
import { StorageServiceModule } from 'angular-webstorage-service';
import { EditComponent } from './edit/edit.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  //{path: 'about/:city', component: AboutComponent}
  {path: 'about', component: AboutComponent},
  {path: 'edit', component: EditComponent}
]

@NgModule({
  declarations: [
    AppComponent, HomeComponent, AboutComponent, EditComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    StorageServiceModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
