import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { Emi } from '../emi';
import { EmiPayment } from '../emi-payment';
import { FormBuilder,FormGroup } from '@angular/forms';

@Component({
  selector: 'app-emi-payment',
  templateUrl: './emi-payment.component.html',
  styleUrls: ['./emi-payment.component.css']
})
export class EmiPaymentComponent implements OnInit {

  emi : Emi;
  emiPayment : EmiPayment;
  emiPaymentForm : FormGroup;

  constructor(private http:HttpClient, private formBuilder:FormBuilder, private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.emi = JSON.parse(localStorage.getItem("emi"));
    this.emiPaymentForm = this.formBuilder.group({
      amountEachMonth:['']
    });
  }

  onSubmit(){

    let q = new Date();
    let m = q.getMonth()+1;
    let d = q.getDay();
    let y = q.getFullYear();

    let date = new Date(y,m,d);
    let r = new Date();
    let m2 = q.getMonth()+2;
 
    let y2 = q.getFullYear();

    let date2 = new Date(y2,m2,4);

    // let day = new Date().getDate().toString();
    // let  month = new Date().getMonth().toString() + 1;
    // let year = new Date().getFullYear().toString();

    // let date = day+"/"+month+"/"+year;

    let currentDate = date.toString();
 

   this.emiPayment = new EmiPayment;
   this.emiPayment.emiPaymentReceieved = this.emi.amountEachMonth;
  
   this.emiPayment.emiPaymentReceivedDate = currentDate;
  
   this.emiPayment.emi = this.emi;
   if (date>date2){
     
      this.emiPayment.emiPaymentOntime = "N";
   }
   else{
  
    this.emiPayment.emiPaymentOntime = "Y";
   }
   alert(JSON.stringify(this.emiPayment));
   this.userService.addMonthlyEmiPayment(this.emiPayment).subscribe(data=>{
    this.router.navigate(['dashboard']);
});
  }

}