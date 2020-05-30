import { Component, OnInit } from '@angular/core';
import {SearchService} from "../../service/search.service";
import {BookSearch} from "../../model/booksearch.model";
import {FormBuilder, FormGroup} from "@angular/forms";
import {BookLoanService} from "../../service/book-loan.service";
import {Router} from "@angular/router";
import {BookLoan} from "../../model/bookLoan.model";

@Component({
  selector: 'app-search-book',
  templateUrl: './search-book.component.html',
  styleUrls: ['./search-book.component.scss']
})
export class SearchBookComponent implements OnInit {
  searchStr: string;
  bookList: BookSearch[] = [];
  displayCheckOut: boolean = false;
  checkOutForm: FormGroup;
  selectedIsbn: string = "";

  constructor(private searchService: SearchService, private fb: FormBuilder, private bookLoanService: BookLoanService,
              private router: Router) { }

  ngOnInit(): void {
    this.checkOutForm = this.fb.group({
        cardId:[],
      }
    );
  }

  getBooks() {
    console.log(this.searchStr);
    this.searchService.getAllBooks(this.searchStr).subscribe(data => {
        this.bookList = data;
      }
    );
  }

  openCheckOutDialog(data: BookSearch) {
    this.selectedIsbn = data.isbn;
    this.displayCheckOut = true;
  }

  checkOutBook() {
    let bookLoan: BookLoan = new BookLoan();
    bookLoan.isbn = this.selectedIsbn;
    bookLoan.cardId = this.checkOutForm.value.cardId;
    this.bookLoanService.checkOutBook(bookLoan)
                        .subscribe(
                          data =>{
                              console.log(data);
                              this.displayCheckOut = false;
                              this.router.navigate(['/book-loans'], {
                                queryParams: {
                                  "bookLoan": data
                                }});
                           }
                        );
  }
}
