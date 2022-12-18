import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Microservices } from "./microservices";


@Injectable({
    providedIn: 'root'
})
export class ChecklistClient {

    constructor(private http:HttpClient){}

    welcomeCheck(){
        return this.http.get(Microservices['checklist']+"checklist",{
            responseType: 'text'
        });
    }

    auditCheckListQuestions(jwt:string, auditType:string){

        return this.http.get(Microservices['checklist']+"AuditCheckListQuestions/"+auditType);
    }
}
