import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { CookieService } from 'angular2-cookie/services/cookies.service';

import { appRoutes } from './routes';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { ReimbursementsComponent } from './components/reimbursements/reimbursements.component';
import { ReimbursementComponent } from './components/reimbursement/reimbursement.component';
import { NavComponent } from './nav/nav/nav.component';
import { LogreimbursementComponent } from './components/logreimbursement/logreimbursement.component';
import { RegisterComponent } from './components/register/register.component';
import { StatuspipePipe } from './pipes/statuspipe.pipe';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ReimbursementsComponent,
    ReimbursementComponent,
    NavComponent,
    LogreimbursementComponent,
    RegisterComponent,
    StatuspipePipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, {useHash: true})
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
