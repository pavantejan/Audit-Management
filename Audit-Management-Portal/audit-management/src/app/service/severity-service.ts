import { Injectable } from "@angular/core";
import { SeverityClient } from "../HttpClient/severity-client";
import { AuthResponse } from '../model/auth-response';
import { ChecklistService } from "./checklist-service";

@Injectable({
    providedIn: 'root'
})
export class SeverityService {

    constructor(
        private severityClient:SeverityClient,
        private authResponse:AuthResponse,
        private checkListService:ChecklistService
    ){}

    projectExecutionStatus(){
        console.log("Hi i am in severity service ");
        console.log(this.checkListService.questions);
        return this.severityClient.getProjectExecutionStatus(this.authResponse,this.checkListService);

    }
}
