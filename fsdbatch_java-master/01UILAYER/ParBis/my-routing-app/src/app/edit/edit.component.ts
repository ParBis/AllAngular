import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {EditService} from './edit.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
  providers: [EditService]
})
export class EditComponent implements OnInit {

  private todoObj;
  private todos;
  constructor(private route: ActivatedRoute, private router: Router, public editService: EditService) {   
    console.log('Edit CONSTRUCTOR **')
  }

  ngOnInit() {
    //console.log('ON INIT Edit **', this.todoObj)
    
    this.editService.getTodo()
    .then((res) =>{
        //console.log('In the edit component' ,res);
        this.todoObj = res;
        
    console.log('ON INIT Edit **', this.todoObj)
    })
  }
  backHome(){
    this.router.navigateByUrl('/');
  }

  updateTodo(todo: string, todo1: string, todo2: string, todo3: string){
    //console.log(todo);
    this.editService.updateTodo({name: todo, age: todo1, contact: todo2, email: todo3})
    .then((res) =>{
        console.log('In the Edit component -- post' ,res);
        this.todos = res;
        this.router.navigateByUrl('/');
    })
}
}
