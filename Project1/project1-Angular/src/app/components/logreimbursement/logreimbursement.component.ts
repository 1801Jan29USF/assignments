import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-logreimbursement',
  templateUrl: './logreimbursement.component.html',
  styleUrls: ['./logreimbursement.component.css']
})
export class LogreimbursementComponent implements OnInit {
  reimbCredential = {
    username: '',
    password: '',
    description: '',
    type: '',
    amount: 0.0
  };

  constructor(private client: HttpClient, private cookie: CookieService, private route: ActivatedRoute,
    private router: Router) {
    this.route.queryParams.subscribe(params => {
      this.reimbCredential.username = params['username'];
      this.reimbCredential.password = params['password'];
  });
  }

  ngOnInit() {
  }

  newReimbursement() {
    console.log(`${this.reimbCredential.type}, ${this.reimbCredential.description}`);
    this.client.post(`${environment.context}newreimbursement`, this.reimbCredential,
    {withCredentials: true})
      .subscribe(
        (succ: any) => {
          console.log('Success!');
        },
        (err) => {
          alert('failed to submit');
        }
      );
  }

}
