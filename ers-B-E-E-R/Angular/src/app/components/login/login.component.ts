import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { environment } from '../../../environments/environment';
import { Router } from '@angular/router';
import { User } from '../../beans/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = {
    username: '',
    password: ''
  };

  // user: User;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.client.post(`${environment.context}login`, this.credentials, { withCredentials: true })
      .subscribe(
        (succ: any) => {
          this.cookie.putObject('user', succ);
          // this.user = this.cookie.get('user');
          this.router.navigate(['/reimbursement']);
        },
        (err) => {
          alert('failed to log in');
        }
      );
  }

}
