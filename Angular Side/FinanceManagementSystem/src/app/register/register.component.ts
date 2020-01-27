import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators ,FormsModule,ReactiveFormsModule} from '@angular/forms';
import { UserService } from '../user.service';
import { Login } from '../login';
import { Customer } from '../customer';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  addForm:FormGroup;
  router: any;
  submitted: boolean = false;

  constructor(private http:HttpClient,private formBuilder:FormBuilder,private userService: UserService) { 

  }

  ngOnInit() {
    this.addForm=this.formBuilder.group({
      username:[''],
      password:[''],
      comfirmPassword:[''],
      customerName:[''],
      customerDob:[''],
      customerEmailId:[''],
      customerPhoneNo:[''],
      customerAnnualIncome:[''],
      customerAddress:[''],
      customerBankName:[''],
      customerSavingsAccount:[''],
      customerIfscCode:['']

     
  });
  
}
get f() { return this.addForm.controls; }


  addCustomer():void{
  
   
       let login: Login = new Login();
       login.customer = new Customer();
       login.username = this.addForm.controls.username.value;
       console.log(login.username);
       login.password = this.addForm.controls.password.value;
       login.customer.customerName = this.addForm.controls.customerName.value;
       login.customer.customerDob = this.addForm.controls.customerDob.value;
       login.customer.customerEmailId = this.addForm.controls.customerEmailId.value;
       login.customer.customerPhoneNo = this.addForm.controls.customerPhoneNo.value;
       login.customer.customerAnnualIncome = this.addForm.controls.customerAnnualIncome.value;
       login.customer.customerAddress = this.addForm.controls.customerAddress.value;
       login.customer.customerBankName= this.addForm.controls.customerBankName.value;
       login.customer.customerSavingsAccount = this.addForm.controls.customerSavingsAccount.value;
       login.customer.customerIfscCode = this.addForm.controls.customerIfscCode.value;

       
    
       this.userService.createUser(login).subscribe(data=>{
          alert('customer is added');
        });
      }}