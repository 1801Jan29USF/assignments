import { Component, OnInit } from '@angular/core';
import { NewUser } from '../../beans/newuser';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  newUser = new NewUser();

  constructor(private client: HttpClient, private cookie: CookieService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
  }

  register() {
    this.client.post(`${environment.context}register`, this.newUser,
    {withCredentials: true})
      .subscribe(
        (succ: any) => {
          console.log('Success!');
          this.router.navigateByUrl('/login');
        },
        (err) => {
          alert('failed to register');
        }
      );
  }



}
