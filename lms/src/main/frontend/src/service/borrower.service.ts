import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Borrower} from "../model/borrower.model";
import {Observable} from "rxjs";
import {environment} from "../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class BorrowerService {

  constructor(private http: HttpClient) { }

  addNewBorrower(borrower: Borrower): Observable<Borrower>{
    return this.http.post<Borrower>(environment.borrowerUrl, borrower);
  }
}
