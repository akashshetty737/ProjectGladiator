import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from './login';


@Injectable({
    providedIn: 'root'
  })
export class UserService {
    constructor(private http:HttpClient) { }
  baseUrl:string = 'http://192.168.13.72:9090';
   
  
  
  createUser(login: Login) {
        return this.http.post(this.baseUrl+'/register', login);
    }
  
  loginUser(login: Login){
     return this.http.get<Login>(this.baseUrl+'/'+login.username);
  }
  
  }
