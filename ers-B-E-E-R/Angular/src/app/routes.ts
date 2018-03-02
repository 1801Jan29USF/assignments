import { Routes } from '@angular/router';
import { Component } from '@angular/core';
import { LoginComponent } from './components/login/login.component';
import { ReimbursementComponent } from './components/reimbursement/reimbursement.component';
import { CookieService } from 'angular2-cookie/services/cookies.service';

export const appRoutes: Routes = [
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'reimbursement',
        component: ReimbursementComponent,
        // canActivate: [
        //     CookieService
        // ]
    }
];
