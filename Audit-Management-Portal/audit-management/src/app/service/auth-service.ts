import { Injectable } from "@angular/core";
import { AuthClient } from "../HttpClient/auth-client";
import { AuthRequest } from "../model/auth-request";
import { AuthResponse } from "../model/auth-response";
import { Observable } from 'rxjs';
import { SecurityToken } from "../model/security-token";
import { LoginStatus } from "../model/login-status";
import { Router } from "@angular/router";

@Injectable({
    providedIn: "root"
})
export class AuthService {

    private flag: boolean = false;
    private token: string = "";

    constructor(
        private authRequest: AuthRequest,
        private authClient: AuthClient,
        private securityToken: SecurityToken,
        private loginStatus: LoginStatus,
        private authResponse: AuthResponse,
        private router: Router
    ) { }

    getUsername() {
        return this.authResponse.Name;
    }

    getRefreshFlag() {
        return this.flag;
    }

    setRefreshFlag(Flag: boolean) {
        this.flag = Flag;
    }

    getLoginStatus(){
        return this.loginStatus.Status;
    }

    generateSecurityToken(username: string, password: string) {

        this.authRequest.Username = username;
        this.authRequest.Password = password;

        return this.authClient.authenticate(this.authRequest);
    }

    validateToken(jwt: string) {
        console.log("auth service validate token" + jwt);
        return this.authClient.validate(jwt);
    }

    authCheck() {
        return this.authClient.welcomeCheck();
    }

    resetData() {
        console.log("in reset");
        this.securityToken.Jwt = "";
        localStorage.removeItem("token");
        this.loginStatus.Status = false;

        this.authResponse.Name = "";
        this.authResponse.ProjectName = "";
        this.authResponse.IsValid = false;
        this.flag = false;
    }

    syncData(name: string, projectName: string) {
        console.log("in sync data");
        if (localStorage.getItem('token') == null && this.securityToken.Jwt != "") {
            localStorage.setItem('token',this.securityToken.Jwt);
        }else if(localStorage.getItem('token') != "" && this.securityToken.Jwt == ""){
            this.securityToken.Jwt = localStorage.getItem('token') || "";
        }
        else{
            localStorage.setItem('token',this.securityToken.Jwt);
        }
        this.loginStatus.Status = true;
        this.authResponse.Name = name;
        this.authResponse.ProjectName = projectName;
        this.authResponse.IsValid = true;
        this.flag = true;
    }

    checkAuthWhenPageRefresh() {

        if (localStorage.getItem('token') == null) {
            if (this.loginStatus.Status) {
                localStorage.setItem('token', this.securityToken.Jwt);
            }
            else {
                this.router.navigate(['login']);
            }
        } else {
            this.token = localStorage.getItem('token') || this.securityToken.Jwt;
            this.securityToken.Jwt = this.token;
            this.validateToken(this.token).subscribe(
                (data: any) => {
                    if (data.valid) {
                        console.log("in check auth when refresh 1");
                        this.syncData(data.name, data.projectName);
                    } else {
                        console.log("in check auth when refresh 23");
                        this.resetData();
                        this.router.navigate(['login']);
                    }
                },
                (err) => {
                    console.log("in check auth when refresh in error while validate");
                    this.router.navigate(['error']);
                },
                () => {
                    if (this.loginStatus.Status) {
                        this.flag = true;
                    } else {
                        this.resetData();
                        this.router.navigate(['login']);
                    }
                }
            );
        }
    }

}
