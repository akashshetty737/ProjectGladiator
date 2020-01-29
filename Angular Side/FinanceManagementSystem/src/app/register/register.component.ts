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
  array: any = [];

  constructor(private http:HttpClient,private formBuilder:FormBuilder,private userService: UserService) { 

  }
 

  ngOnInit() {
    this.addForm=this.formBuilder.group({
      username:['',Validators.required],
      password:['',Validators.required],
     
      customerName:['' ,Validators.required],
      customerDob:['' ,Validators.required],
      customerEmailId:['',Validators.required],
      customerPhoneNo:['',Validators.required],
      customerAnnualIncome:['',Validators.required],
      customerAddress:['',Validators.required],
      customerBankName:['',Validators.required],
      customerSavingsAccount:['',Validators.required],
      customerIfscCode:['',Validators.required]
   
    
    });
  }

  get customerName() { return this.addForm.get('customerName'); }
  get customerDob() { return this.addForm.get('customerDob'); }
  get customerEmailId() { return this.addForm.get('customerEmailId'); }
  get customerPhoneNo() { return this.addForm.get('customerPhoneNo'); }
  get customerAnnualIncome() { return this.addForm.get('customerAnnualIncome'); }
  get username() { return this.addForm.get('username'); }
  get password() { return this.addForm.get('password'); }
  get customerAddress() { return this.addForm.get('customerAddress'); }
  get customerBankName() { return this.addForm.get('customerBankName'); }
  get customerSavingsAccount() { return this.addForm.get('customerSavingsAccount'); }
  get customerIfscCode() { return this.addForm.get('customerIfscCode'); }






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
          this.array= data;
          alert(this.array.message);
        });
      }
}