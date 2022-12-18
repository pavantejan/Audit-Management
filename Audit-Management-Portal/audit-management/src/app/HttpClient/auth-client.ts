import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { AuthRequest } from "../model/auth-request";
import { AuthResponse } from "../model/auth-response";
import { Microservices } from "./microservices";

@Injectable({
    providedIn: 'root'
})
export class AuthClient {

    constructor(private http: HttpClient) { }

    welcomeCheck(){
        console.log("auth check in client");
        return this.http.get(Microservices['auth']+"authorization",{
            responseType: 'text'
        });
    }

    authenticate(authRequest: AuthRequest) {
        console.log("In authenticate");
        return this.http.post(Microservices['auth']+"authenticate", authRequest, {
            responseType: 'text'
        });
    }

    validate(jwt: string){
        console.log("auth client validate");
        // var headers = new HttpHeaders().set("Authorization", "Bearer " + jwt);
        // let header = new HttpHeaders().set("Authorization","Bearer "+jwt); 
        // console.log("auth client validate 1 " + header.set);

        let headers = new HttpHeaders({
            'Authorization': 'Bearer '+ jwt
        });

        console.log(headers);

        return this.http.post(Microservices['auth']+"validate", headers);
    }
}
