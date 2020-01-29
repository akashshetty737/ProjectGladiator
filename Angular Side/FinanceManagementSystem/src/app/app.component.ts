import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from './user.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Product } from './product';
import { Router } from '@angular/router';
import { Customer } from './customer';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  searchForm:FormGroup;
  product: Product;
  isUserLoggedIn: boolean;
  
constructor(private http:HttpClient, private formBuilder:FormBuilder, private userService: UserService, private router: Router) {
 
 

}

ngOnInit(){
  this.router.navigate(['main']);
  this.searchForm=this.formBuilder.group({
    productName:['']
  });

  let customer : Customer  = JSON.parse(localStorage.getItem("user"));

  if( customer != null){
    this.isUserLoggedIn = true;
  }
  else{
    this.isUserLoggedIn = false;
  }
}

onHome(){
  this.router.navigate(['main']);
}

onRegister(){
  this.router.navigate(['register']);
}

onLogin(){
  this.router.navigate(['login']);
}

onDashboard(){
  this.router.navigate(['dashboard']);
}

onLogOut(){
  localStorage.removeItem("user");
  localStorage.removeItem("emi");
  this.ngOnInit();
  this.router.navigate(['login']);
}

onSubmit(){
let productName : string = (this.searchForm.controls.productName.value);

this.userService.fetchProduct(productName.toLowerCase()).subscribe(data=>{
  this.product = data;
  localStorage.setItem("product", JSON.stringify(this.product));
  this.router.navigate(['/product-info']);

})
}
}
