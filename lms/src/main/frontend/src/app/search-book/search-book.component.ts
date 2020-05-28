import { Component, OnInit } from '@angular/core';
import {SearchService} from "../../service/search.service";
import {BookSearch} from "../../model/booksearch.model";

@Component({
  selector: 'app-search-book',
  templateUrl: './search-book.component.html',
  styleUrls: ['./search-book.component.scss']
})
export class SearchBookComponent implements OnInit {
  searchStr: string;
  bookList: BookSearch[] = [];

  constructor(private searchService: SearchService) { }

  ngOnInit(): void {
  }

  getBooks() {
    console.log(this.searchStr);
    this.searchService.getAllBooks(this.searchStr).subscribe(data => {
        this.bookList = data;
      }
    );
  }
}
