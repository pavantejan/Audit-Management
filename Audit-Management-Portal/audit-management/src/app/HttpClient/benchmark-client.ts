import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Microservices } from "./microservices";


@Injectable({
    providedIn: 'root'
})
export class BenchmarkClient {
    constructor(private http:HttpClient){}

    welcomeCheck(){
        return this.http.get(Microservices['benchmark']+"benchmark",{
            responseType: 'text'
        });
    }
}
