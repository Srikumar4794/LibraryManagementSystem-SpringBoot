import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-borrower-management',
  templateUrl: './borrower-management.component.html',
  styleUrls: ['./borrower-management.component.scss']
})
export class BorrowerManagementComponent implements OnInit {

  constructor(private fb: FormBuilder) {
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
          zipCode: new FormControl("")
        }),
        ssn: new FormControl("", Validators.required),
        phoneNum: new FormControl("")
      }
    );
  }
}
