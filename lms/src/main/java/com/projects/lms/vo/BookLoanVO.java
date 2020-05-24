package com.projects.lms.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class BookLoanVO {
    private Long loanId;
    private String isbn;
    private Long cardId;
    private Date dateIn;
    private Date dueDate;
    private Date dateOut;
}
