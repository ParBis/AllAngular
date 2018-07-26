import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { UsersComponent } from './users/users.component';


const routes: Routes = [
    { path: '', redirectTo: '/users', pathMatch: 'full' },
    { path: 'user/:id', component: UserComponent },
    // { path: 'user/:id', component: HeroDetailComponent },
    { path: 'users', component: UsersComponent }
  ];


@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    CommonModule,
    FormsModule
  ],
  exports: [ RouterModule ],
  declarations: [UserComponent, UsersComponent]
})
export class AppRoutingModule { }