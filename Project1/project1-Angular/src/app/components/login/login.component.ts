import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { Router, NavigationExtras } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credential = {
    username: '',
    password: ''
  };

  constructor(private client: HttpClient, private cookie: CookieService,
              private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.client.post(`${environment.context}login`, this.credential,
    {withCredentials: true})
      .subscribe(
        (succ: any) => {
          this.cookie.putObject('user', succ);
          const navigationExtras: NavigationExtras = {
            queryParams: {'username': this.credential.username,
                        'password': this.credential.password}
          };
          this.router.navigate(['reimbursements'], navigationExtras);
        },
        (err) => {
          alert('failed to log in');
        }
      );
  }
}
