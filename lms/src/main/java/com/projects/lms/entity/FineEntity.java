package com.projects.lms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "fines")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FineEntity {
    @Id
    @Column(name = "loan_id")
    private Long loanId;

    @Column(name = "fine_amt")
    private Double fineAmount;

    @Column(name = "paid")
    private Boolean paid;

    @JoinColumn(name = "loan_id", referencedColumnName = "loan_id", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private BookLoanEntity bookLoanEntity;
}
