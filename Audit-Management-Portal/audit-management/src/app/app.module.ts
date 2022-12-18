import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'
import { AuthClient } from './HttpClient/auth-client';
import { AuthRequest } from './model/auth-request';
import { AuthService } from './service/auth-service';
import { AuthResponse } from './model/auth-response';
import { SecurityToken } from './model/security-token';
import { LoginStatus } from './model/login-status';
import { TokenIntercepter } from './model/token-intercepter';
import { CheckListComponent } from './check-list/check-list.component';
import { ChecklistClient } from './HttpClient/checklist-client';
import { ChecklistService } from './service/checklist-service';
import { SeverityComponent } from './severity/severity.component';
import { SeverityClient } from './HttpClient/severity-client';
import { SeverityService } from './service/severity-service';
import { BenchmarkClient } from './HttpClient/benchmark-client';
import { ErrorPageComponent } from './error-page/error-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    CheckListComponent,
    SeverityComponent,
    ErrorPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    AuthRequest,
    AuthResponse,
    AuthClient,
    AuthService,
    SecurityToken,
    LoginStatus,
    ChecklistClient,
    ChecklistService,
    SeverityClient,
    SeverityService,
    BenchmarkClient,
    // TokenIntercepter,
    {
      provide: HTTP_INTERCEPTORS,
      useClass : TokenIntercepter,
      multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
