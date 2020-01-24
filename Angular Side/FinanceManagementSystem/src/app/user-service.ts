import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from './login';


@Injectable({
    providedIn: 'root'
  })
export class UserService {
    constructor(private http:HttpClient) { }
  baseUrl:string = 'http://localhost:9090/';
   
  
  
  createUser(login: Login) {
        return this.http.post(this.baseUrl, login);
      }
}
