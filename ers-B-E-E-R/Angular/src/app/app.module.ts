import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';

import { appRoutes } from './routes';
import { LoginComponent } from './components/login/login.component';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { ReimbursementComponent } from './components/reimbursement/reimbursement.component';
import { DatePipe } from '@angular/common';
import { LocalDateTimePipe } from './pipes/local-date-time.pipe';
import { ReimbursementService } from './services/reimbursement.service';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes, { useHash: true }),
    FormsModule
  ],
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    ReimbursementComponent,
    LocalDateTimePipe
   ],
  providers: [
    CookieService,
    DatePipe,
    ReimbursementService
   ],
  bootstrap: [AppComponent]
})
export class AppModule { }
