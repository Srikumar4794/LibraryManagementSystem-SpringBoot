package com.projects.lms.service;

import com.projects.lms.dao.IBookLoanDao;
import com.projects.lms.dto.BookLoanDTO;
import com.projects.lms.entity.BookLoanEntity;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Data
public class BookLoanService {
    private final IBookLoanDao bookLoanDao;

    public List<BookLoanEntity> getBookLoans(Long cardId, String borrowerName, String isbn)
    {
        return bookLoanDao.fetchBookLoans(cardId, borrowerName, isbn);
    }

    public BookLoanEntity insertBookLoan(BookLoanDTO bookLoanDTO)
    {
        BookLoanEntity bookLoanEntity = BookLoanEntity.builder()
                        .isbn(bookLoanDTO.getIsbn())
                        .cardId(bookLoanDTO.getCardId())
                        .dateIn(new Date())
                        .build();

        return bookLoanDao.save(bookLoanEntity);
    }
}
