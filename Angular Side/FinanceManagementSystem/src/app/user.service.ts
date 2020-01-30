import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from './login';
import { Product } from './product';
import { Emi } from './emi';
import { EmiPayment } from './emi-payment';

@Injectable({
    providedIn: 'root'
  })
export class UserService {
    constructor(private http:HttpClient) { }
  baseUrl:string = 'http://192.168.13.72:9090';
   
  
  
  createUser(login: Login) {
        return this.http.post<any>(this.baseUrl, login);
    }
  
  loginUser(login: Login){
     return this.http.get<Login>(this.baseUrl+'/'+login.username);
  }
  
  fetchProduct(productName: string){
    return this.http.get<Product>(this.baseUrl+'/products/'+productName);
  }

  addEmi(emi: Emi){
    return this.http.post<any>(this.baseUrl+'/products/buy',emi);
  }

  fetchEmi(customerId: number){
    return this.http.get<Emi>(this.baseUrl+'/emi/'+customerId);
  }

  addMonthlyEmiPayment(emiPayment: EmiPayment){
    return this.http.post<Emi>(this.baseUrl+'/payment',emiPayment);
  }

  }
