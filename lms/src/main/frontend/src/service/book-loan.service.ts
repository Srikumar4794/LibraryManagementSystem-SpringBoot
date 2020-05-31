import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BookLoan} from "../model/bookLoan.model";
import {environment} from "../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BookLoanService {

  constructor(private http: HttpClient) { }

  checkOutBook(bookLoan: BookLoan): Observable<BookLoan>{
    return this.http.post<BookLoan>(environment.bookLoanUrl, bookLoan);
  }

  getAllBooks(): Observable<BookLoan[]>{
    return this.http.get<BookLoan[]>(environment.allBookLoansUrl);
  }

  checkInBook(bookLoan: BookLoan): Observable<BookLoan> {
    return this.http.put<BookLoan>(environment.bookLoanUrl + bookLoan.loanId, bookLoan);
  }
}
