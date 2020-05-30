import { Component, OnInit } from '@angular/core';
import {BookLoan} from "../../model/bookLoan.model";
import {ActivatedRoute} from "@angular/router";
import {BookLoanService} from "../../service/book-loan.service";
import * as moment from 'moment';

@Component({
  selector: 'app-book-loans',
  templateUrl: './book-loans.component.html',
  styleUrls: ['./book-loans.component.scss']
})
export class BookLoansComponent implements OnInit {
  bookLoans: BookLoan[] = [];

  constructor(private route: ActivatedRoute, private bookLoanService: BookLoanService) { }

  ngOnInit(): void {
    this.bookLoanService.getAllBooks().subscribe(
      (data) => {
        this.bookLoans = data;
        console.log(this.bookLoans);
      }
    );
  }

  getFormattedDate(timestamp: number): string{
    return timestamp > 0 ? moment(timestamp).format("DD MMM YYYY") : "";
  }
}
