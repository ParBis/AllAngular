import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LOCAL_STORAGE, StorageService } from 'angular-webstorage-service';
 
const STORAGE_KEY = "my-todos"
const STORAGE_KEY_TODO = "my-todo"
const STORAGE_KEY_INDEX = "index"

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

@Injectable()
export class EditService {

    
    
    todos : Array<object> = []; 
    
    todoObj : object;
    index: number;
    constructor(private http : HttpClient, @Inject(LOCAL_STORAGE) private storage: StorageService){

    }

    getTodo() {
        return new Promise((resolve, reject) => {
            this.todoObj = this.storage.get(STORAGE_KEY_TODO)
            this.todos = this.storage.get(STORAGE_KEY)
            this.index = this.storage.get(STORAGE_KEY_INDEX)
            resolve(this.todoObj)
        })

    }

    updateTodo(obj){
        //console.log('---todos--',this.todos);
        //console.log('---index--',this.index);
        return new Promise((resolve, reject) => {
            //this.todos.splice(this.index, 1);
            //this.todos.push(obj)
            this.todos.splice(this.index, 1, obj)
            // Auto stringyfies the object
            this.storage.set(STORAGE_KEY, this.todos);
            resolve(this.todos)
        })
    }


}