package com.projects.lms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_loans")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookLoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_id")
    private Long loanId;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "card_id")
    private Long cardId;

    @Column(name = "date_in")
    private Date dateIn;

    @Column(name = "date_out")
    private Date dateOut;

    @JoinColumn(name = "isbn", referencedColumnName = "isbn", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private BookEntity bookEntity;

    @JoinColumn(name = "card_id", referencedColumnName = "Card_ID", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private BorrowerEntity borrowerEntity;
}
