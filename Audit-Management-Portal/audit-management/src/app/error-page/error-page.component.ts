import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth-service';

@Component({
  selector: 'app-error-page',
  templateUrl: './error-page.component.html',
  styleUrls: ['./error-page.component.css']
})
export class ErrorPageComponent implements OnInit {

  constructor(
    private authService:AuthService,
    private router:Router
    ) {

  }
  ngOnInit(): void {
    this.authService.resetData();
  }

  goBack() {
    // this.authService.resetData();
    this.router.navigate(["login"]);
}

}
