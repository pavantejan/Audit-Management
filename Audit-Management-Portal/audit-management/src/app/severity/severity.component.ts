import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BenchmarkClient } from '../HttpClient/benchmark-client';
import { AuditResponse } from '../model/audit-response';
import { AuthResponse } from '../model/auth-response';
import { AuthService } from '../service/auth-service';
import { ChecklistService } from '../service/checklist-service';
import { SeverityService } from '../service/severity-service';

@Component({
  selector: 'app-severity',
  templateUrl: './severity.component.html',
  styleUrls: ['./severity.component.css']
})
export class SeverityComponent implements OnInit{

  status : string = "";

  auditResponse: AuditResponse = {
    auditId: 0,
    projectName: "",
    projectManagerName: "",
    creationDateAndTime: new Date(),
    projectExecutionStatus: "",
    remedialActionDuration: ""
  }

  constructor(
    private severityService: SeverityService,
    private router: Router,
    private authService:AuthService,
    private checklistService:ChecklistService,
    private benchmarkService:BenchmarkClient
  ) { }


  getExecutionStatus(){

    this.severityService.projectExecutionStatus().subscribe(
      (data: any) => {
        console.log("from severity component");
        this.auditResponse = data;
        console.log(this.auditResponse);
        this.status = this.auditResponse.projectExecutionStatus
      },
      (err) =>{
        
        this.router.navigate(["error"]);
      }
    );

  }

  backToChecklist(){
    this.router.navigate(['checklist']);
  }

  ngOnInit(): void {
    console.log("in severity component");

    
    this.authService.authCheck().subscribe(
      (data)=>{},
      (err) =>{this.router.navigate(['error'])},
      ()=>{
        this.checklistService.checklistCheck().subscribe(
          (data)=>{},
          (err)=>{this.router.navigate(['error'])},
          ()=>{
            this.benchmarkService.welcomeCheck().subscribe(
              (data)=>{},
              (err)=>{this.router.navigate(['error'])},
              ()=>{
                this.authService.checkAuthWhenPageRefresh();
                  if(localStorage.getItem("token")!=null){
                    
                    if(this.authService.getLoginStatus() && this.authService.getRefreshFlag()){
                      // console.log("XXXXXXXXXXXXXXXYYYYYYYYYYY" + this.authService.getRefreshFlag());
                      this.getExecutionStatus();
                    }
                    else if(this.authService.getLoginStatus() || !this.authService.getRefreshFlag()){
                      // console.log("XXXXXXXXXXXXXXXYYYYYYYYYYY1" + this.authService.getRefreshFlag());
                      this.authService.setRefreshFlag(true);
                      this.router.navigate(["checklist"]);
                    }
                    else{
                      // console.log("XXXXXXXXXXXXXXXYYYYYYYYYYY2" + this.authService.getRefreshFlag());
                      this.authService.resetData();
                      this.router.navigate(['login']);
                    }
                  }
                  else{
                    // console.log("XXXXXXXXXXXXXXXYYYYYYYYYYY3" + this.authService.getRefreshFlag());
                    this.authService.resetData();
                    this.router.navigate(['login']);
                  }
              }
            );
          }
        );
      }
    );

    
  }

  onClick() {
    
  }

}
