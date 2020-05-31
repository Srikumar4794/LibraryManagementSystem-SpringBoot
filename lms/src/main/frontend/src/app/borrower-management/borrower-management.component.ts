import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Borrower} from "../../model/borrower.model";
import {BorrowerService} from "../../service/borrower.service";

@Component({
  selector: 'app-borrower-management',
  templateUrl: './borrower-management.component.html',
  styleUrls: ['./borrower-management.component.scss']
})
export class BorrowerManagementComponent implements OnInit {

  constructor(private fb: FormBuilder, private borrowerService: BorrowerService) {
  }

  borrowerForm: FormGroup;

  ngOnInit(): void {
    this.initializeBorrowerForm();
  }

  initializeBorrowerForm() {
    this.borrowerForm = this.fb.group(
      {
        name: new FormGroup({
          firstName: new FormControl("", Validators.required),
          lastName: new FormControl("", Validators.required)
        }),
        address: new FormGroup({
          street: new FormControl(""),
          apt: new FormControl(""),
          city: new FormControl(""),
          state: new FormControl(""),
        }),
        ssn: new FormControl("", Validators.required),
        phoneNum: new FormControl("")
      }
    );
  }

  addBorrower() {
    let borrower: Borrower = new Borrower();
    if(this.borrowerForm.value){
      borrower.name = this.getName(this.borrowerForm.value.name);
      borrower.address = this.getAddress(this.borrowerForm.value.address);
      borrower.ssn = this.borrowerForm.value.ssn;
      borrower.phoneNumber = this.borrowerForm.value.phoneNumber;
    }
    this.borrowerService.addNewBorrower(borrower).subscribe(
      (data) => {
        console.log("Borrower added with id: " + data.cardId);
      },
      error => {
        console.log(error.error.message);
      }
    )
  }

  getName(formElement: any): string{
    return formElement.firstName + ' ' + formElement.lastName;
  }

  getAddress(formElement: any): string{
    return formElement.apt + ',' + formElement.street + ',' + formElement.city + ',' + formElement.state;
  }
}
