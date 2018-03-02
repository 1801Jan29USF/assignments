import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../beans/reimbursement';
import { ActivatedRoute, NavigationExtras, Router } from '@angular/router';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {
  reimbursements: Array<Reimbursement> = [];
  credential = {
    username: '',
    password: ''
  };
  currentStatus = '';

  constructor(private client: HttpClient, private cookie: CookieService, private route: ActivatedRoute,
              private router: Router) {
    this.route.queryParams.subscribe(params => {
      this.credential.username = params['username'];
      this.credential.password = params['password'];
  });
  }

  ngOnInit() {
    this.getReimbursements();
  }

  getReimbursements() {
    this.client.post(`${environment.context}reimbursements`, this.credential,
    {withCredentials: true})
      .subscribe(
        (succ: any) => {
          this.reimbursements = succ;
          console.log(this.reimbursements);
        },
        (err) => {
          alert('failed to fetch');
        }
      );
  }
  rNav(r: Reimbursement) {
    const navigationExtras: NavigationExtras = {
      queryParams: {'amount': r.amount,
                  'submitted': r.submitted,
                  'resolved': r.resolved,
                  'description': r.description,
                  'status': r.status,
                  'type': r.type,
                  'author': r.author,
                  'resolver': r.resolver,
                  'id': r.id,
                  'username': this.credential.username,
                  'password': this.credential.password
                }
    };
    this.router.navigate(['/reimbursements/reimbursement'], navigationExtras);
  }

  lNav() {
    const navigationExtras: NavigationExtras = {
      queryParams: {
                  'username': this.credential.username,
                  'password': this.credential.password
                }
    };
    this.router.navigate(['/reimbursements/logreimbursement'], navigationExtras);
  }

}
