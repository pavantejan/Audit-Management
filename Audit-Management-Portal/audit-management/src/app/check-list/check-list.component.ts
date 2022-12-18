import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HeaderComponent } from '../header/header.component';
import { ChecklistQuestions } from '../model/checklist-questions';
import { AuthService } from '../service/auth-service';
import { ChecklistService } from '../service/checklist-service';

@Component({
  selector: 'app-check-list',
  templateUrl: './check-list.component.html',
  styleUrls: ['./check-list.component.css']
})
export class CheckListComponent implements OnInit {

  // myComponent:boolean = false;
  // status:boolean = false;
  questions: ChecklistQuestions[] = [];
  // auditType = "Internal";
  auditType: string = "";
  // message:string = "";
  flag: boolean = false;

  constructor(
    private checkListService: ChecklistService,
    private router: Router,
    private authService: AuthService,
    // private headerComponent: HeaderComponent
  ) { }

  ngOnInit(): void {
    // throw new Error('Method not implemented.');
    // console.log("In checklist");

    this.flag = false;
    this.authService.authCheck().subscribe(
      (data) => { },
      (err) => {
        // console.log("cehfcklist-error" + err);
        this.router.navigate(['error']);
      },
      () => {
        this.checkListService.checklistCheck().subscribe(
          (data) => { },
          (err) => {
            // console.log("cehfcklist-error1");
            this.router.navigate(['error']);
          },
          () => {
            console.log("cehfcklist when page refresh ");
            this.authService.checkAuthWhenPageRefresh();
            // this.headerComponent.headerRefresh();
            // this.status = this.authService.getLoginStatus();
            // console.log("status in checklist");
            // this.status = true;
          }
        );
      }
    );



  }

  getQuestions() {
    console.log("hi" + this.auditType + "hi");
    this.checkListService.getQuestionsService(this.auditType).subscribe(
      (data: any) => {
        console.log(data);
        this.questions = data;
        console.log(this.questions.keys);
      },
      (err) => {
        this.router.navigate(['error']);
      }
    );
  }

  logout() {

    this.authService.resetData();
    this.router.navigate(["login"]);

  }

  responseYes(index: number) {
    this.questions[index].response = "YES";
  }

  responseNo(index: number) {
    this.questions[index].response = "NO";
  }

  onSubmit() {
    this.checkListService.questions = this.questions;
    console.log("in checklist submit");
    this.router.navigate(["severity"]);
  }



}
