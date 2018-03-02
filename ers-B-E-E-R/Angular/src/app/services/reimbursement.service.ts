import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable()
export class ReimbursementService {

  constructor(private client: HttpClient) { }

  getAuthor(authorId): string {
    let author: string;
    this.client.get(`${environment.context}user/${authorId}`, { withCredentials: true })
      .subscribe(
        (succ: any) => {
          author = `${succ.firstName} ${succ.lastName}`;
          console.log(author);
        },
        (err) => {
          alert('failed to send GET user id request, please try again');
        }
      );
      console.log(author);
      return author;
  }

}
