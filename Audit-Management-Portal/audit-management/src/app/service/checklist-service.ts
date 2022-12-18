import { Injectable } from "@angular/core";
import { ChecklistClient } from "../HttpClient/checklist-client";
import { ChecklistQuestions } from "../model/checklist-questions";
import { SecurityToken } from "../model/security-token";


@Injectable({
    providedIn: 'root'
})
export class ChecklistService {

    auditType:string = "";
    questions: ChecklistQuestions[] = [];

    constructor(private checkListClient:ChecklistClient,private securityToken:SecurityToken){}

    checklistCheck(){
        return this.checkListClient.welcomeCheck();
    }

    getQuestionsService(auditType:string){
        this.auditType = auditType;
        return this.checkListClient.auditCheckListQuestions(this.securityToken.Jwt,auditType);
    }
}
