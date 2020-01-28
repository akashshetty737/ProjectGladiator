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
  this.searchForm=this.formBuilder.group({
    productName:['']
  });

  let customer : Customer  = JSON.parse(localStorage.getItem("user"));

  if(customer.customerId > 0){
    this.isUserLoggedIn = true;
  }
  else{
    this.isUserLoggedIn = false;
  }




}

onLogOut(){
  localStorage.removeItem("user");
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
