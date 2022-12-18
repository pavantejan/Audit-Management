import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { AuthResponse } from "../model/auth-response";
import { ChecklistService } from "../service/checklist-service";
import { Microservices } from "./microservices";


@Injectable({
    providedIn: 'root'
})
export class SeverityClient {

    constructor(
        private http: HttpClient
    ) { }

    welcomeCheck() {
        return this.http.get(Microservices['severity'] + "severity", {
            responseType: 'text'
        });
    }

    getProjectExecutionStatus(authResponse: AuthResponse, checkListService: ChecklistService) {
        // return "";
        return this.http.post(Microservices['severity'] + "ProjectExecutionStatus", {
            "projectName": authResponse.ProjectName,
            "projectManagerName": authResponse.Name,
            "applicationOwnerName": authResponse.Name,
            "auditDetail": {
                "auditType": checkListService.auditType,
                "AuditDate": "",
                "auditQuestions": checkListService.questions
            }
        }
        );
    }
}
