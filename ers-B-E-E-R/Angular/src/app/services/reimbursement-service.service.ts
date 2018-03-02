import { Injectable } from '@angular/core';
import { ReimbursementType } from '../beans/reimbursementType';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable()
export class ReimbursementServiceService {

  types: Array<ReimbursementType>;

  constructor(private client: HttpClient) { }

  getTypes() {
    this.client.get(`${environment}reimbursement`);
  }

}
