import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment";
import {Observable} from "rxjs";
import {Fine} from "../model/fines.model";

@Injectable({
  providedIn: 'root'
})
export class FineService {

  constructor(private http: HttpClient) { }

  refreshFines(): void{
    this.http.get(environment.refreshFinesUrl).subscribe(
      (data) => {
        console.log("done");
      }
    );
  }

  getFinesForBorrower(cardId: number): Observable<Fine[]>{
    return this.http.get<Fine[]>(environment.finesUrl + cardId);
  }

  payFine(fine: Fine): Observable<Fine>{
    return this.http.put<Fine>(environment.payFinesUrl + fine.loanId, fine);
  }
}
