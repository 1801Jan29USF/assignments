import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Router } from '@angular/router';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { Reimbursement } from '../../beans/reimbursement';
import { CurrencyPipe } from '@angular/common';
import { LocalDateTimePipe } from '../../pipes/local-date-time.pipe';
import { ReimbursementType } from '../../beans/reimbursementType';
import { ReimbursementService } from '../../services/reimbursement.service';
import { User } from '../../beans/user';

@Component({
  selector: 'app-reimbursement',
  templateUrl: './reimbursement.component.html',
  styleUrls: ['./reimbursement.component.css']
})
export class ReimbursementComponent implements OnInit {

  data = {
    amount: 0,
    description: '',
    typeId: 0,
    authorId: 0
  };

  types: Array<ReimbursementType>;
  reimbursements: Array<Reimbursement>;
  role: string;
  roleId: number;
  userId: number;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router,
    private reimService: ReimbursementService) { }

  ngOnInit() {
    this.userId = JSON.parse(this.cookie.get('user')).id;
    this.data.authorId = JSON.parse(this.cookie.get('user')).id;
    this.roleId = JSON.parse(this.cookie.get('user')).roleId;
    this.client.get(`${environment.context}role/${this.roleId}`, { withCredentials: true })
      .subscribe(
        (succ: any) => {
          this.role = `${succ.role}`;
        },
        (err) => {
          alert('failed to send GET role request, please try again');
        }
      );
    this.client.get(`${environment.context}type`, { withCredentials: true })
      .subscribe(
        (succResp: any) => {
          this.types = succResp;
        },
        (err) => {
          alert('failed to send GET reimbursement request, please try again');
        }
      );
    this.getReims(`${environment.context}reimbursement/${this.data.authorId}`);
  }

  empTickets() {
    this.getReims(`${environment.context}reimbursement/`);
  }

  myTickects() {
    this.getReims(`${environment.context}reimbursement/${this.data.authorId}`);
  }

  getReims(reimbUrl: string) {
    this.client.get(reimbUrl, { withCredentials: true })
      .subscribe(
        (succResp: any) => {
          this.reimbursements = succResp;
          this.reimbursements.forEach(reimb => {
            reimb.type = this.types.filter(t => t.id === reimb.typeId)[0].type;
            // reimb.author = this.reimService.getAuthor(reimb.authorId);
            this.client.get(`${environment.context}user/${reimb.authorId}`, { withCredentials: true })
              .subscribe(
                (succ: any) => {
                  reimb.author = `${succ.firstName} ${succ.lastName}`;
                },
                (err) => {
                  alert('failed to send GET author id request, please try again');
                }
              );
            // if (reimb.resolverId !== undefined) {
            if (reimb.resovlerId > 0) {
              this.client.get(`${environment.context}user/${reimb.resovlerId}`, { withCredentials: true })
                .subscribe(
                  (succ: any) => {
                    reimb.resolver = `${succ.firstName} ${succ.lastName}`;
                  },
                  (err) => {
                    alert('failed to send GET resolver id request, please try again');
                  }
                );
            }
            this.client.get(`${environment.context}status/${reimb.statusId}`, { withCredentials: true })
              .subscribe(
                (succ: any) => {
                  reimb.status = `${succ.status}`;
                },
                (err) => {
                  alert('failed to send GET status request, please try again');
                }
              );
          });
        },
        (err) => {
          alert('failed to send GET reimbursement request, please try again');
        }
      );
  }

  requestReimb() {
    this.client.post(`${environment.context}reimbursement`, this.data, { withCredentials: true })
      .subscribe(
        (succ: any) => {
          succ.author = `${JSON.parse(this.cookie.get('user')).firstName} ${JSON.parse(this.cookie.get('user')).lastName}`;
          succ.status = 'Pending';
          this.reimbursements.push(succ);
        },
        (err) => {
          alert('failed to send reimbursement request, please try again');
        }
      );
  }

  approve(str: string, reimbId: number, r: Reimbursement) {
    // approve() {
    const reimb = {
      id: reimbId,
      resovlerId: JSON.parse(this.cookie.get('user')).id
    };
    this.client.post(`${environment.context}approval/${str}`, reimb, { withCredentials: true })
      .subscribe(
        (succ: any) => {
          r = succ;
        },
        (err) => {
          alert('failed to send approval request, please try again');
        }
      );
  }

  logout() {
    this.cookie.removeAll();
    this.router.navigate(['/login']);
  }

  sortAsc(array: Array<object>, prop: string) {
    array.sort(this.dynamicSort(prop));
  }

  dynamicSort(property) {
    console.log(property);
    let sortOrder = 1;
    if (property[0] === '-') {
      sortOrder = -1;
      property = property.substr(1);
    }
    return function (a, b) {
      const result = (a[property] < b[property]) ? -1 : (a[property] > b[property]) ? 1 : 0;
      return result * sortOrder;
    };
  }
}
