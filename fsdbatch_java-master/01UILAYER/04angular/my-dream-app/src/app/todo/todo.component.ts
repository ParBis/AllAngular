import { Component, OnInit } from '@angular/core';
import {TodooService} from './todoo.service'


// Component should only contain methods that manipulate dom. Things like business logic, AJAX... have to be moved to Service class
@Component({
    selector: 'my-todo',
    template: `
        <div>   
            <input class="form-control" #todo (change)="0" type="text" placeholder="Enter a todo!!"/>
            <button class="btn btn-primary" (click) = "addTodo(todo.value)">Add Todo</button>

            <hr/>

            <ul class="list-group">
                <li [ngClass]="getClassForItem(todo.isDone)" *ngFor="let todo of todos;let i = index">
                        <span>
                            <p [ngStyle]= "{'color': getColor(todo.isDone)}">{{todo.text}}</p>
                            <button class="btn btn-danger" (click)="removeTodo(i)">X</button>
                        </span>
                    </li>
            </ul>

            <div>

                <strong>{{message}}</strong>
                <button class="btn btn-success" (click) = "synch()">Sync with the Server</button>
                <button class="btn btn-success" (click) = "fetchTodos()">Load from the Server</button>

            </div>
        <div>
    `,
    providers: [TodooService]
})
export class TodoComponent implements OnInit {

    private todos;
    private message: string = ""
       
    constructor(public todoService: TodooService) {
        console.log('CONSTRUCTOR **')
    }

    ngOnInit() { 
        console.log('ON INIT **')
        this.todoService.getTodos()
        .then((res) =>{
            console.log('In the component' ,res);
            this.todos = res;
        })
    }

    getClassForItem(isDone: boolean){
        if(isDone){
            return "list-group-item disabled"
        }
        else{
            return "list-group-item"
        }
    }
    getColor(isDone: boolean){
        if(isDone){
            return "green"
        }
        else{
            return "black"
        }
    }

    fetchTodos(){
        this.todoService.fetchTodos()
        .subscribe((res) => {
            console.log(res)
            this.todos = res;
        })
        // .then((res) =>{
        //     console.log('In the component' ,res);
        //     this.todos = res;
        //     this.message = "Fetched Successfully!!"
        // })
    }

    synch(){
        this.todoService.synchTodo(this.todos)
        .subscribe((res) => {
            this.message = "Successfully updated!!"
            console.log('In the component -- synch' ,res);
            // this.todos = res;
        })
        // .then((res) =>{
        //    this.message = "Successfully updated!!"
        //     console.log('In the component -- synch' ,res);
        //     // this.todos = res;
        // })
    }
    
    addTodo(todo: string){
        this.todoService.addTodo({text: todo})
        .then((res) =>{
            console.log('In the component -- post' ,res);
            this.todos = res;
        })
    }

    removeTodo(index: number){
        this.todoService.removeTodo(index)
        .then((res) =>{
            console.log('In the component -- remove' ,res);
            this.todos = res;
        })
    }

   

}