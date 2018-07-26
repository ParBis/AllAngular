import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {AboutService} from './about.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css'],
  providers: [AboutService]
})
export class AboutComponent implements OnInit {

  private todos;
  private todoObj;

  constructor(private route: ActivatedRoute, private router: Router, public aboutService: AboutService) {   
    console.log('About CONSTRUCTOR **')
  }
  /*city: string = '';
  ngOnInit() {
    let city = this.route.snapshot.paramMap.get('city')
    this.city = city
  }*/
  ngOnInit() { 
    console.log('ON About component INIT **')
    this.aboutService.getTodos()
    .then((res) =>{
        console.log('In the about component blank page' ,res);
        this.todos = res;
    })
    
    //console.log('In the about component INIT' ,todoObj);
    /*this.aboutService.getTodo()
    .then((res) =>{
        console.log('In the about component edit page' ,res);
        this.todoObj = res;
        
    console.log('ON INIT Edit **', this.todoObj)
    })*/
}

  addTodo(todo: string, todo1: string, todo2: string, todo3: string){
    this.aboutService.addTodo({name: todo, age: todo1, contact: todo2, email: todo3})
    .then((res) =>{
        console.log('In the About component -- post' ,res);
        this.todos = res;
        this.router.navigateByUrl('/');
    })
}


backHome(){
  this.router.navigateByUrl('/');
}
  

}
