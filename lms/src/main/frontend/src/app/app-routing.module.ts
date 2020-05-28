import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SearchBookComponent} from "./search-book/search-book.component";
import {BookLoansComponent} from "./book-loans/book-loans.component";
import {BorrowerManagementComponent} from "./borrower-management/borrower-management.component";
import {FinesComponent} from "./fines/fines.component";


const routes: Routes = [
  { path: 'home', component: SearchBookComponent },
  { path: 'book-loans', component: BookLoansComponent},
  { path: 'borrowers', component: BorrowerManagementComponent},
  { path: 'fines', component: FinesComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
