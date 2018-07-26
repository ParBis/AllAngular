import { Component, OnInit } from '@angular/core';
import { UserService } from './../service/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
	providers: [UserService]
})
export class UsersComponent implements OnInit {
  
	users: Array<any>=[];
	constructor(private userService: UserService){}

	ngOnInit() {
        this.loadUsers();
    }

    deleteUser(index) {
        console.log('index delete------>'+index);
        this.userService.removeUser(index)
            .then(res => {
                console.log(res);
                this.loadUsers();
                // if (res.success == true) {
                //     this.loadUsers();
                // }
            }, err => {
                console.log('server err');
                console.log(err);
            })
            .catch(err => {
                console.log('client err');
                console.log(err);
            })
    }

    loadUsers() {
        this.userService.getUsers()
            .then(res => {
                console.log(res);
                this.users = res;
                // if (res.success == true) {
                //     this.users = res.data;
                //     console.log(this.users)
                // }
            }, err => {
                console.log('server err');
                console.log(err);
            })
            .catch(err => {
                console.log('client err');
                console.log(err);
            })

    }

}
