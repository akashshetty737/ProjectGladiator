import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from './login';
import { Product } from './product';
import { Emi } from './emi';


@Injectable({
    providedIn: 'root'
  })
export class UserService {
    constructor(private http:HttpClient) { }
  baseUrl:string = 'http://localhost:9090';
   
  
  
  createUser(login: Login) {
        return this.http.post(this.baseUrl, login);
    }
  
  loginUser(login: Login){
     return this.http.get<Login>(this.baseUrl+'/'+login.username);
  }
  
  fetchProduct(productName: string){
    return this.http.get<Product>(this.baseUrl+'/products/'+productName);
  }

  addEmi(emi: Emi){
    return this.http.post(this.baseUrl+'/products/buy',emi);
  }

  }
