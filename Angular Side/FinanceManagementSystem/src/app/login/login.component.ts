import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { Login } from '../login';
import { AppComponent } from '../app.component';
import { Router } from '@angular/router';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm:FormGroup;
  loginData: Login = new Login();

  constructor(private http:HttpClient,private formBuilder:FormBuilder,private userService: UserService, private parent: AppComponent, private router: Router) { 

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
      if(login.password == this.loginData.password){
        alert("Successful");
        localStorage.setItem("user",JSON.stringify(this.loginData.customer));
        this.parent.ngOnInit();
        this.router.navigate(['dashboard']);
     }
     else{
       alert("Please Try Again")
     }
    });
    

  }

}
