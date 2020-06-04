import { Component, OnInit } from '@angular/core';
import {FineService} from "../../service/fine.service";

@Component({
  selector: 'app-fines',
  templateUrl: './fines.component.html',
  styleUrls: ['./fines.component.scss']
})
export class FinesComponent implements OnInit {
  selectedCardID: number;

  constructor(private fineService: FineService) { }

  ngOnInit(): void {
  }

  refreshFines(): void{
    this.fineService.refreshFines();
  }

}
