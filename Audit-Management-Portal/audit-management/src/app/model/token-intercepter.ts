import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { SecurityToken } from "./security-token";


@Injectable({
    providedIn:'root'
})
export class TokenIntercepter implements HttpInterceptor{

    constructor(private securityToken:SecurityToken){}

    intercept(req: HttpRequest<any>, next: HttpHandler){

        console.log("In intercepter");

        console.log(req);
        
        let reqHeader = req.clone({
            setHeaders : {
                Authorization : "Bearer " + this.securityToken.Jwt
            }
        });
        console.log(reqHeader);

        return next.handle(reqHeader);
    }
}
