import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { UserService } from './../service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  providers: [UserService]
})
export class UserComponent implements OnInit {
  user: any = {
      userId: '',
      id: '',
      title: '',
      body: ''
  };
  title: string = "Create User";
  id: number;

  constructor(private userService: UserService, private route: ActivatedRoute, private location: Location ){ }

  ngOnInit(){
      const id = +this.route.snapshot.paramMap.get('id');
      console.log("id---------->"+id);
      if(+id >= 0){
          this.title = `Edit User`;
          this.id = +id;
          this.getUser(this.id);
      }
  }

  addUser() {
    console.log('addUser-----');
      this.userService.createUser(this.user)
          .then(res => {
              console.log(res);
              this.goBack();
            //   if (res.success == true) {
            //       this.goBack();
            //   }
          }, err => {
              console.log('server err');
              console.log(err);
          })
          .catch(err => {
              console.log('client err');
              console.log(err);
          })
  }

  editUser() {
      this.userService.updateUser(this.id, this.user)
          .then(res => {
              console.log(res);
              this.goBack();
            //   if (res.success == true) {
            //       this.goBack();
            //   } else {
            //       alert("could not update");
            //   }
          }, err => {
              console.log('server err');
              console.log(err);
          })
          .catch(err => {
              console.log('client err');
              console.log(err);
          })

  }

  getUser(index) {
    console.log('index getUser------>'+index);
      this.userService.getUser(index)
          .then(res => {
              console.log(res);
              this.user = res;
            //   if (res.success == true) {
            //       this.user = res.data;
            //   }
          }, err => {
              console.log('server err');
              console.log(err);
          })
          .catch(err => {
              console.log('client err');
              console.log(err);
          })
  }

  goBack(){
      this.location.back();
  }


}
