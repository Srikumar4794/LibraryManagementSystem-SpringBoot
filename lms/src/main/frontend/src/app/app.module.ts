import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {TableModule} from "primeng/table";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {DialogModule} from "primeng";
import { SearchBookComponent } from './search-book/search-book.component';
import { BookLoansComponent } from './book-loans/book-loans.component';
import { BorrowerManagementComponent } from './borrower-management/borrower-management.component';
import { FinesComponent } from './fines/fines.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchBookComponent,
    BookLoansComponent,
    BorrowerManagementComponent,
    FinesComponent,
    NavBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    TableModule,
    FormsModule,
    ReactiveFormsModule,
    DialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
