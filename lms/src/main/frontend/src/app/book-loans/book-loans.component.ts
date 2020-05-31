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
  columns: any =
    [{field: 'isbn', header: 'ISBN'},
     {field: 'cardId', header: 'Borrower ID'},
     {field: 'dateOut', header: 'Check-out Date'},
     {field: 'dueDate', header: 'Due Date'},
     {field: 'dateIn', header: 'Check-In Date'}
    ];

  constructor(private route: ActivatedRoute, private bookLoanService: BookLoanService) { }

  ngOnInit(): void {
    this.bookLoanService.getAllBooks().subscribe(
      (data) => {
        this.bookLoans = data;
        this.sortBookLoansBasedOnCheckOut();
        console.log(this.bookLoans);
      }
    );
  }

  getFormattedDate(timestamp: number): string{
    return timestamp > 0 ? moment(timestamp).format("DD MMM YYYY") : "";
  }

  checkInBook(row: BookLoan) {
    this.bookLoanService.checkInBook(row).subscribe(
      data => {
        this.bookLoans.splice(this.bookLoans.indexOf(row), 1);
        this.bookLoans.push(data);
        this.sortBookLoansBasedOnCheckOut();
      }
    );
  }

  sortBookLoansBasedOnCheckOut(){
    this.bookLoans.sort((loan1, loan2) => loan2.dateOut - loan1.dateOut);
  }

}
