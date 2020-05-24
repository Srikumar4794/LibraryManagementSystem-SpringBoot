package com.projects.lms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookLoanDTO {
    @NotNull
    @Size(max = 10)
    private String isbn;

    @NotNull
    private Long cardId;
}
