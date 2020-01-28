import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { Login } from '../login';
import { Router } from '@angular/router';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm:FormGroup;

  loginData: Login = new Login();

  constructor(private http:HttpClient,private formBuilder:FormBuilder,private userService: UserService,
    private router:Router) { 

  }


  ngOnInit() {
    this.loginForm = this.formBuilder.group({
    username:['',Validators.required],
    password:['',Validators.required]
    })
  }
  get username() { return this.loginForm.get('username'); }
  get password() { return this.loginForm.get('password'); }

  loginCustomer():void{
    let login: Login = new Login();
    
    login.username = this.loginForm.controls.username.value;
    login.password = this.loginForm.controls.password.value;

    this.userService.loginUser(login).subscribe(data=>{
      this.loginData = data;
      console.log(this.loginData.password);
      if(login.password == this.loginData.password){
        alert("Successful");
        this.router.navigate(['/main']);
     }
     else{
       alert("Please Try Again")
     }

    });

    

  }

}
