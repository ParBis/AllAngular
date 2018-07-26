import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LOCAL_STORAGE, StorageService } from 'angular-webstorage-service';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators'
 
const STORAGE_KEY = "my-todos"

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

@Injectable()
export class TodooService {

    
    
    todos : Array<object> = []; 
    constructor(private http : HttpClient, @Inject(LOCAL_STORAGE) private storage: StorageService){

    }

    fetchTodos(): Observable<any>{
        return this.http.get('http://localhost:3000/todos', httpOptions)
        .pipe(map((res)=> {
            console.log('In the map function', res)
            return res;
        }))
        
    }

    getTodos() {
        // get this todos from AJAX or localStorage

        // AJAX
        // return this.http.get('http://localhost:3000/todos', httpOptions)
        // .toPromise()

        return new Promise((resolve, reject) => {
            this.todos = this.storage.get(STORAGE_KEY) || []
            resolve(this.todos)
        })

        // Hard-Coded
        // return new Promise((resolve, reject) => {
        //     resolve(this.todos);
        // })

        // .then((res)=>{
        //     console.log(res);
        // });
        // return this.todos;
    }

    addTodo(obj){
        // Hard-coded
        // this.todos.push(obj);

        return new Promise((resolve, reject) => {
            this.todos.push(obj)
            // Auto stringyfies the object
            this.storage.set(STORAGE_KEY, this.todos);
            resolve(this.todos)
        })

       

        // return this.http.post('http://localhost:3000/todos', obj , httpOptions)
        // .toPromise()
    }

    synchTodo(todos): Observable<any>{
       
        return this.http.put('http://localhost:3000/todos', todos , httpOptions)
    }

    removeTodo(index: number){
        return new Promise((resolve, reject) => {
            this.todos = this.storage.get(STORAGE_KEY)
            this.todos.splice(index, 1);
            this.storage.set(STORAGE_KEY, this.todos)
            resolve(this.todos)
        })
    }


}