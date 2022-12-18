import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckListComponent } from './check-list/check-list.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { LoginComponent } from './login/login.component';
import { SeverityComponent } from './severity/severity.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"checklist",component:CheckListComponent},
  {path:"severity",component:SeverityComponent},
  {path:"error",component:ErrorPageComponent},
  {path:"**",redirectTo:"/login"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
