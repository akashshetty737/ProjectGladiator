import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user-service';
import { Login } from '../login';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm:FormGroup;
  router: any;
  loginData: Login = new Login();

  constructor(private http:HttpClient,private formBuilder:FormBuilder,private userService: UserService) { 

  }


  ngOnInit() {
    this.loginForm = this.formBuilder.group({
    username:['',Validators.required],
    password:['',Validators.required]
    })
  }

  loginCustomer():void{
    let login: Login = new Login();
    
    login.username = this.loginForm.controls.username.value;
    login.password = this.loginForm.controls.password.value;

    this.userService.loginUser(login).subscribe(data=>{
      this.loginData = data;
      console.log(this.loginData.password);
      if(login.password == this.loginData.password){
        alert("Successful");
     }
     else{
       alert("Please Try Again")
     }
    });
    

  }

}
