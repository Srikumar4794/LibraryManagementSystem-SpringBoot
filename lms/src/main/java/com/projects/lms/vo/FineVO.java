package com.projects.lms.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class FineVO {
    private Long loanId;
    private Double fineAmount;
    private Boolean paid;
    private String isbn;
    private String bookName;
    private String cardId;
}
