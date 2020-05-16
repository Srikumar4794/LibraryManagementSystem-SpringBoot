import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Author} from "../model/author.model";

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient ) {}

  private readonly addAllAuthorsUrl: string = "http://localhost:8080/api/authors";
  private readonly insertAuthorUrl: string = "http://localhost:8080/api/author";
  private readonly updateAuthorUrl: string = "http://localhost:8080/api/author/";

  public getAllAuthors(): Observable<Author[]>{
    return this.http.get<Author[]>(this.addAllAuthorsUrl);
  }

  public insertAuthor(author: Author){
    this.http.post<Author>(this.insertAuthorUrl, author);
  }

  public updateAuthorName(id: number, name: string){
    this.http.put<Author>(this.updateAuthorUrl + id, name);
  }
}
