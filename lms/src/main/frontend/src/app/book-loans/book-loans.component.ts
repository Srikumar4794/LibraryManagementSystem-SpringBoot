import {Component, OnDestroy, OnInit} from '@angular/core';
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
     {field: 'borrowerName', header: 'Borrower Name'},
     {field: 'dateOut', header: 'Check-out Date'},
     {field: 'dueDate', header: 'Due Date'},
     {field: 'dateIn', header: 'Check-In Date'}
    ];
  searchOptions: any = [{value: "isbn", desc: "Book ID" }, {value: "cardId" , desc: "Borrower ID" }, {value: "bName" , desc: "Borrower Name"}];
  recentlyCheckedOut: BookLoan;
  selectedOption: any = "cardId";
  searchValue: any;

  constructor(private route: ActivatedRoute, private bookLoanService: BookLoanService) {
  }

  ngOnInit(): void {
    this.filterBasedOnNav();
    this.sortBookLoansBasedOnCheckOut();
  }

  filterBasedOnNav() {
    this.route.queryParams.subscribe(params =>{
      this.recentlyCheckedOut = JSON.parse(params["bookLoan"]);
      this.bookLoans = this.bookLoans.filter(loan => loan.cardId == this.recentlyCheckedOut.cardId);
    });
  }

  ngOnDestroy(): void {
    this.recentlyCheckedOut = null;
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

  getBookLoans() {
    console.log(this.selectedOption, this.searchValue);
    let cardId: any = (this.selectedOption == "cardId") ? Number(this.searchValue): " ";
    let isbn: string = (this.selectedOption == "isbn")? this.searchValue.toString(): " ";
    let bName: string = (this.selectedOption == "bName")? this.searchValue: " ";
    this.bookLoanService.getBookLoansBySearchTerm(cardId, bName, isbn).subscribe(
      (data) => {
        console.log(data);
        this.bookLoans = data;
      }
    )
  }
}
