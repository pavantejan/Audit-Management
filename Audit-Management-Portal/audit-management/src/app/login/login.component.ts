import { Component, OnInit } from '@angular/core';
import { AuthClient } from '../HttpClient/auth-client';
import { AuthRequest } from '../model/auth-request';
// import { LoginStatus } from '../model/login-status';
import { observable, Subscription } from 'rxjs';
import { AuthService } from '../service/auth-service';
import { SecurityToken } from '../model/security-token';
import { LoginStatus } from '../model/login-status';
import { AuthResponse } from '../model/auth-response';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = "";
  password = "";
  message = "";
  // isDisabled:boolean = true;

  // constructor(private loginStatus:LoginStatus){

  // }
  // private firstObservable:Subscription;

  constructor(
    private authService: AuthService,
    private securityToken:SecurityToken,
    private loginStatus:LoginStatus,
    private authResponse:AuthResponse,
    private router:Router
  ) { }


  ngOnInit(): void {

    // this.isDisabled = this.username==='' && this.password==='';
    // this.securityToken.Jwt="";
    // console.log

  }

  logIn() {
    // this.message
    console.log("xyz " + this.username + " hi");

    if (this.username.trim().length == 0 || this.password.trim().length == 0) {
      this.message = "Please provide valid credentials";
    }

    this.authService.generateSecurityToken(this.username, this.password).subscribe(
      (data) => {
        console.log(data);
        if (data.includes(".")) {
          this.message = "";
          this.loginStatus.Status=true;
          this.securityToken.Jwt=data;
        }
      },
      (err) => {
        this.message = "Please provide valid credentials";
        console.log(err);
      },
      ()=>{
        if(this.loginStatus.Status){
          console.log("Validate");
          this.authService.validateToken(this.securityToken.Jwt).subscribe(
            (data:any) =>{
              console.log("Validate1");
              console.log(data.name);

              this.authResponse.Name =  data.name;
              this.authResponse.ProjectName = data.projectName;
              this.authResponse.IsValid = data.isValid;                         
            },
            (err) =>{

            },
            () =>{
              localStorage.setItem("token",this.securityToken.Jwt);
              console.log("redirect to checklist");
              this.router.navigate(['checklist']);
            }
          )
        }
      }
    );
  }

}