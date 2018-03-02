import { Pipe, PipeTransform } from '@angular/core';
import { Reimbursement } from '../beans/reimbursement';

@Pipe({
  name: 'statuspipe'
})
export class StatuspipePipe implements PipeTransform {

  transform(reimbursements: Array<Reimbursement>, currentStatus: string): Array<Reimbursement> {
    if (currentStatus === '') {
      return reimbursements;
    } else {
      return reimbursements.filter(reimbursement => reimbursement.status === currentStatus);
    }
  }
}
