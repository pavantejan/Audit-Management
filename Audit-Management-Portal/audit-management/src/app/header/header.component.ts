import { Component, Input, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { CheckListComponent } from '../check-list/check-list.component';
import { LoginStatus } from '../model/login-status';
import { AuthService } from '../service/auth-service';
import { ChecklistService } from '../service/checklist-service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  // @Input() Status:boolean = false;

  // @Input() component: boolean = false;

  username: string = "";
  loginStatus: boolean = false;
  token:any = "";

  constructor(
    private logStatus: LoginStatus,
    private router: Router,
    private authService: AuthService,
    private checklistService: ChecklistService
  ) { }

  // ngOnChanges(changes: SimpleChanges) {
  //   console.log(changes);

  //   this.loginStatus = this.component;
  //   this.username = this.authService.getUsername();
  //   // console.log(this.loginStatus+" "+this.username);

  // }

  ngOnInit(): void {
    // throw new Error('Method not implemented.');
    // this.loginStatus = this.logStatus.Status;

    console.log(this.loginStatus);


    console.log(this.loginStatus);



    // this.token = localStorage.getItem('token');

    // console.log(this.token + " token");

    // if (this.loginStatus == true || this.token != null ) {

    //   this.authService.authCheck().subscribe(
    //     (data) => { },
    //     (err) => {
    //       console.log("header-error" + err);
    //       this.router.navigate(['error']);
    //     },
    //     () => {
    //       this.checklistService.checklistCheck().subscribe(
    //         (data) => { },
    //         (err) => {
    //           // console.log("cehfcklist-error1");
    //           this.router.navigate(['error']);
    //         },
    //         () => {
    //           console.log("checklist header when page refresh ");
    //           this.authService.checkAuthWhenPageRefresh();
    //         }
    //       );
    //     }
    //   );

    

      this.username = this.authService.getUsername();
      this.loginStatus = this.logStatus.Status;

    // }


  }


  logout() {
    this.authService.resetData();
    this.router.navigate(["login"]);
  }

}
