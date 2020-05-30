import { Component, OnInit } from '@angular/core';
import {BookLoan} from "../../model/bookLoan.model";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-book-loans',
  templateUrl: './book-loans.component.html',
  styleUrls: ['./book-loans.component.scss']
})
export class BookLoansComponent implements OnInit {
  bookLoans: BookLoan[] = [];


  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params =>{
        console.log(params["bookLoan"]);
        this.bookLoans.push(params["bookLoan"]);
    }
    )
  }

}
