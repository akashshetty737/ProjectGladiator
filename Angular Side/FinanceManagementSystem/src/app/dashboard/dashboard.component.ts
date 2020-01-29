import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { Card } from '../card';
import { CardType } from '../card-type';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { Emi } from '../emi';
import { EmiPayment } from '../emi-payment';


@Component({
    selector: 'dashboard',
    styleUrls: ['./dashboard.component.css'],
    templateUrl: 'dashboard.component.html'
})

export class DashboardComponent implements OnInit {
    customer: Customer;
    card: Card;
    cardType: CardType;
    cardActive: boolean;
    emiList: any
    emiPayment: EmiPayment;
  
    constructor(private http:HttpClient, private userService: UserService, private router: Router) {}

    ngOnInit() {
        this.customer = JSON.parse(localStorage.getItem("user"));
        if(this.customer.customerApprovedStatus == "Y"){
        this.cardActive = true;
        this.card = this.customer.customerCard;
        this.cardType = this.customer.customerCard.cardType;
        this.userService.fetchEmi(this.customer.customerId).subscribe(data=>{
          localStorage.setItem("emiList", JSON.stringify(data));
    });

        this.emiList = JSON.parse(localStorage.getItem("emiList"));
        }
        else{
        this.cardActive = false;
        }
    }

    payEmi(emi){
        localStorage.setItem("emi",JSON.stringify(emi));
        this.router.navigate(['emi-payment']); 
    }

}