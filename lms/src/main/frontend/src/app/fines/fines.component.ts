import { Component, OnInit } from '@angular/core';
import {FineService} from "../../service/fine.service";
import {Fine} from "../../model/fines.model";

@Component({
  selector: 'app-fines',
  templateUrl: './fines.component.html',
  styleUrls: ['./fines.component.scss']
})
export class FinesComponent implements OnInit {
  selectedCardID: number;
  displayCardIdHead: number;
  columns: any = [
               {field: 'loanId', header: 'Loan ID', width:'15px'},
               {field: 'cardId', header: 'Card ID', width:'15px'},
               {field: 'isbn', header: 'ISBN', width:'30px'},
               {field: 'bookName', header: 'Book Name', width:'50px'},
               {field: 'fineAmount', header: 'Fine', width:'15px'},
               {field: 'paid', header: 'Fine Status', width:'30px'},
              ];
  fineData: Fine[];

  constructor(private fineService: FineService) { }

  ngOnInit(): void {

  }

  refreshFines(): void{
    console.log("Refresh");
    this.fineService.refreshFines();
  }

  getFines(){
    this.fineService.getFinesForBorrower(this.selectedCardID).subscribe(
      (data) => {
        this.fineData = data;
        this.displayCardIdHead = this.selectedCardID;
      }
    )
  }

}
