package com.projects.lms.controller;

import com.projects.lms.dto.BookLoanDTO;
import com.projects.lms.service.BookLoanService;
import com.projects.lms.vo.BookLoanVO;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Data
public class BookLoanController {
    private final BookLoanService bookLoanService;

    @GetMapping(path = "/api/v1/book-loans/{cardId}/{name}/{bookId}")
    public List<BookLoanVO> getBookLoans(@PathVariable("cardId") Long cardId, @PathVariable("name") String borrowerName, @PathVariable("bookId") String isbn)
    {
        return bookLoanService.getBookLoans(cardId, borrowerName, isbn);
    }

    @GetMapping(path = "/api/v1/book-loans/")
    public List<BookLoanVO> getAllBookLoans()
    {
        return bookLoanService.getAllBookLoans();
    }

    @PostMapping(path = "/api/v1/book-loan/")
    public BookLoanVO checkOutBook(@RequestBody @Valid BookLoanDTO bookLoanDTO)
    {
        return bookLoanService.insertBookLoan(bookLoanDTO);
    }

    @PutMapping(path = "/api/v1/book-loan/{loanId}")
    public BookLoanVO checkInBook(@PathVariable Long loanId)
    {
        return bookLoanService.checkInBook(loanId);
    }

}
