import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { UserComponent } from './user/user.component';
import {Routes, RouterModule} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { StorageServiceModule } from 'angular-webstorage-service';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';


const routes: Routes = [
  // {path: '', component: UsersComponent},
  // {path: 'user', component: UserComponent}
  { path: '', redirectTo: '/users', pathMatch: 'full' },
  { path: 'user/:id', component: UserComponent },
  { path: 'users', component: UsersComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    StorageServiceModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
