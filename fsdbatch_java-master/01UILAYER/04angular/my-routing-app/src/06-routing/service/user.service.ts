import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class UserService {
    users: string[] = [];
    private server: string = `http://localhost:7000`;
    constructor(private http: Http) {}

    getUsers(): Promise<any> {
        return this.http.get(`${this.server}/users`)
            .toPromise()
            .then(response => {
                return response.json();
            })
            .catch(err => err);
    }
    getUser(index: number): Promise<any> {
        return this.http.get(`${this.server}/user/${index}`)
            .toPromise()
            .then(response => {
                return response.json();
            })
            .catch(err => err);
    }
    createUser(newUser: string): Promise<any> {
        return this.http.post(`${this.server}/users`, {newUser})
            .toPromise()
            .then(response => {
                return response.json();
            })
            .catch(err => err);
    }
    removeUser(index: number): Promise<any> {
        return this.http.delete(`${this.server}/users/${index}`)
            .toPromise()
            .then(response => {
                return response.json();
            })
            .catch(err => err);
    }
    updateUser(index: number, user: string): Promise<any> {
        return this.http.put(`${this.server}/users/${index}`, {user})
            .toPromise()
            .then(response => {
                return response.json();
            })
            .catch(err => err);
    }

}
