import {Component, OnInit} from '@angular/core';
import {Author} from "../model/author.model";
import {AuthorService} from "../service/author.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'frontend';
  authors: Author[] = [];
  displayAuthors: boolean = false;
  addAuthor: boolean = false;
  changeAuthorName: boolean = false;
  authorForm: FormGroup;
  oldAuthor: Author;
  newAuthorName: string;

  constructor(private authorService: AuthorService, private fb: FormBuilder) {
  }

  ngOnInit(){
    this.initAuthorForm();
    this.oldAuthor = {authorId:0, authorName:""};
  }

  initAuthorForm() {
    this.authorForm = this.fb.group(
      {
        authorId: [],
        authorName: [""]
      }
    );
  }

  getAuthors() {
    this.displayAuthors = true;
    this.addAuthor = false;
    this.authorService.getAllAuthors().subscribe(
      (data) => {
        this.authors = data.slice(0, 50);
        console.log(this.authors);
      }
    )
  }

  displayAddAuthor() {
      this.addAuthor = true;
      this.displayAuthors = false;
  }

  addNewAuthor() {
    let authorObj: Author = {authorId: this.authorForm.value.authorId, authorName: this.authorForm.value.authorName};
    console.log(authorObj);
    this.authorService.insertAuthor(authorObj);
  }

  editAuthorName(author: Author){
    this.changeAuthorName = true;
    this.oldAuthor = author;
  }

  updateAuthor(){
    this.authorService.updateAuthorName(this.oldAuthor.authorId, this.newAuthorName);
  }
}
