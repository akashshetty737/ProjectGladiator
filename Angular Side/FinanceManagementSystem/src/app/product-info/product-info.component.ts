import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { Emi } from '../emi';
import { Customer } from '../customer';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-product-info',
  templateUrl: './product-info.component.html',
  styleUrls: ['./product-info.component.css']
})
export class ProductInfoComponent implements OnInit {
  product:Product;
  customer:Customer;
  emiPeriodForm: FormGroup;
  array: any = [];
  

  constructor(private http:HttpClient, private formBuilder:FormBuilder, private userService: UserService, private router: Router, private parent: AppComponent) { }

  ngOnInit() {
    this.product = JSON.parse(localStorage.getItem("product"));
    this.customer = JSON.parse(localStorage.getItem("user"));
    this.emiPeriodForm=this.formBuilder.group({
      emiMonths:['']
    });
  }

  onSubmit(){
    if(this.customer != null){
    let emi:Emi = new Emi();

    let startMonth = new Date().getMonth() + 2;
    let startYear = new Date().getFullYear();

    let endYear = new Date().getFullYear();

    let endMonth = new Date().getMonth() + 2 + parseInt(this.emiPeriodForm.controls.emiMonths.value);
    if(endMonth > 12){
      endMonth = endMonth - 12;
      endYear = endYear + 1;
    }

    startMonth.toString;
    startYear.toString;
    endMonth.toString;
    endYear.toString;

   
    let emiStartDate ="4/"+startMonth+"/"+startYear;
    let emiEndDate = "4/"+endMonth+"/"+endYear;
     emi.emiStartDate = emiStartDate;
     emi.emiEndDate = emiEndDate;
     emi.totalAmountPaid = 0;
     emi.emiBalanceRemaining = this.product.productPrice;
     emi.amountEachMonth = this.product.productPrice/this.emiPeriodForm.controls.emiMonths.value;
     emi.emiActiveStatus = "A";
     emi.product = this.product;
     emi.customer = this.customer;
     this.userService.addEmi(emi).subscribe(data=>{
              this.array= data;
             alert(this.array.message);
             this.parent.ngOnInit;
             this.router.navigate(['main']);
     });
   }
   else{
     this.router.navigate(['login']);
   }
  }
}
