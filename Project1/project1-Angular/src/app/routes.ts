import { Routes } from '@angular/router';
import { Component } from '@angular/core';
import { LoginComponent } from './components/login/login.component';
import { ReimbursementsComponent } from './components/reimbursements/reimbursements.component';
import { ReimbursementComponent } from './components/reimbursement/reimbursement.component';
import { LogreimbursementComponent } from './components/logreimbursement/logreimbursement.component';
import { RegisterComponent } from './components/register/register.component';


export const appRoutes: Routes = [{
  path: 'login',
  component: LoginComponent
},
{
    path: 'reimbursements',
    component: ReimbursementsComponent,
    children: [
      { path: 'reimbursement',
        component: ReimbursementComponent},
      { path: 'logreimbursement',
        component: LogreimbursementComponent}
    ]
},
{
  path: 'register',
  component: RegisterComponent
}

];
