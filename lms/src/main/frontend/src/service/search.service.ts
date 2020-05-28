import { Injectable } from '@angular/core';
import {environment} from "../environments/environment";
import {HttpClient} from "@angular/common/http";
import {BookSearch} from "../model/booksearch.model";

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) {}

  private readonly searchUrl: string = environment.bookSearchUrl;

  public getAllBooks(searchStr: string){
    return this.http.get<BookSearch[]>(this.searchUrl + searchStr);
  }


}
