import { Component, OnInit, Input} from '@angular/core';
import { Reimbursement } from '../../beans/reimbursement';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { environment } from '../../../environments/environment';
import { Resrequest } from '../../beans/resrequest';

@Component({
  selector: 'app-reimbursement',
  templateUrl: './reimbursement.component.html',
  styleUrls: ['./reimbursement.component.css']
})
export class ReimbursementComponent implements OnInit {
  private reimbursement: Reimbursement = new Reimbursement;
  private resrequest: Resrequest = new Resrequest;

  constructor(private client: HttpClient, private cookie: CookieService, private route: ActivatedRoute,
    private router: Router) {
    this.route.queryParams.subscribe(params => {
      this.reimbursement.amount = params['amount'];
      this.reimbursement.submitted = params['submitted'];
      this.reimbursement.resolved = params['resolved'];
      this.reimbursement.description = params['description'];
      this.reimbursement.status = params['status'];
      this.reimbursement.type = params['type'];
      this.reimbursement.author = params['author'];
      this.reimbursement.resolver = params['resolver'];
      this.resrequest.username = params['username'];
      this.resrequest.password = params['password'];
      this.resrequest.id = params['id'];
  });
  }

  ngOnInit() {
  }

  resolveReimbursement(newStatus: String) {
    this.resrequest.newStatus = newStatus;
    this.client.post(`${environment.context}resolve`, this.resrequest,
    {withCredentials: true})
      .subscribe(
        (succ: any) => {
          console.log('Success!');
        },
        (err) => {
          alert('failed to resolve');
        }
      );
  }

}
