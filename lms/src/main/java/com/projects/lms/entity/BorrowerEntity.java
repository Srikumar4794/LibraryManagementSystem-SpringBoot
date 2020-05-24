package com.projects.lms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "borrower")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerEntity {
    @Id
    @Column(name = "Card_ID")
    private Long cardId;

    @Column(name = "Ssn", unique = true)
    private String ssn;

    @Column(name = "Bname")
    private String borrowerName;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone")
    private String phone;
}
