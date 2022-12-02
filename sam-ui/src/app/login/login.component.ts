import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Submittor from '../submittor';
import { UserAuthenticationService } from '../user-authentication.service';
import UserCredential from '../UserCredential';
import { Input } from '@angular/core';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
    email: string =""
    password: string=""
    userType: string="";

    constructor(private userAuthenticationService: UserAuthenticationService, 
      private router : Router){

    }

    ngOnInit(){

    }

    getEmailAndPass(){
      let email = document.getElementById("email1")?.nodeValue;
      let password = document.getElementById("password1")?.nodeValue;
      if(email != null || email != undefined){
        this.email = email;
      }
      else{
        alert("Email cannot be empty");
      }

      if(password != null || password != undefined){
        this.password = password;
      }
      else{
        alert("Password cannot be empty");
      }
    }

    setUserType(userType: string){
      this.userType = userType;
    }

     signIn(){
      //this.getEmailAndPass();

      if(this.userType == ""){
        alert("Select a user type!");
        return;
      }

      let userCred : UserCredential = {
        email : this.email,
        password : this.password
      }

      this.userAuthenticationService.authenticate(userCred, this.userType).subscribe(user=>{
        console.log(user.id);
        sessionStorage.setItem("userId", <string><unknown>user.id);
         this.router.navigateByUrl('\submitter/'+user.id);
      });



    }


}
