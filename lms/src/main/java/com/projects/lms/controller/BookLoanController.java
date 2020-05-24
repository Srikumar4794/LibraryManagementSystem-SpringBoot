package com.projects.lms.controller;

import com.projects.lms.dto.BookLoanDTO;
import com.projects.lms.entity.BookLoanEntity;
import com.projects.lms.service.BookLoanService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Data
public class BookLoanController {
    private final BookLoanService bookLoanService;

    @GetMapping(path = "/api/v1/book-loans/{cardId}/{name}/{bookId}")
    public List<BookLoanEntity> getBookLoans(@PathVariable("cardId") Long cardId, @PathVariable("name") String borrowerName, @PathVariable("bookId") String isbn)
    {
        return bookLoanService.getBookLoans(cardId, borrowerName, isbn);
    }

    @PostMapping(path = "/api/v1/book-loan")
    public BookLoanEntity addBookLoan(@RequestBody @Valid BookLoanDTO bookLoanDTO)
    {
        return bookLoanService.insertBookLoan(bookLoanDTO);
    }

}
