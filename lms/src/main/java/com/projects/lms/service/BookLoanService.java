package com.projects.lms.service;

import com.projects.lms.dao.IBookLoanDao;
import com.projects.lms.dto.BookLoanDTO;
import com.projects.lms.entity.BookLoanEntity;
import com.projects.lms.translator.IBookLoanTranslator;
import com.projects.lms.utils.LibraryDateUtils;
import com.projects.lms.vo.BookLoanVO;
import lombok.Data;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Data
public class BookLoanService {
    private final IBookLoanDao bookLoanDao;

    @Autowired
    private IBookLoanTranslator bookLoanTranslator;

    public List<BookLoanVO> getBookLoans(Long cardId, String borrowerName, String isbn)
    {
        return bookLoanTranslator.toBookLoanVOList(bookLoanDao.fetchBookLoans(cardId, borrowerName, isbn));
    }

    public BookLoanVO insertBookLoan(BookLoanDTO bookLoanDTO)
    {
        BookLoanEntity bookLoanEntity = BookLoanEntity.builder()
                        .isbn(bookLoanDTO.getIsbn())
                        .cardId(bookLoanDTO.getCardId())
                        .dateOut(new Date())
                        .dueDate(LibraryDateUtils.findDueDate(new Date()))
                        .build();

        return bookLoanTranslator.toBookLoanVO(bookLoanDao.save(bookLoanEntity));
    }

    public BookLoanVO updateBookLoan(Long loanId) {
        BookLoanEntity bookLoanEntity = bookLoanDao.findById(loanId).orElseThrow(() -> new IllegalArgumentException("No book loans found for loan id: "));

        bookLoanEntity.setDateIn(new Date());
        bookLoanDao.save(bookLoanEntity);
        return bookLoanTranslator.toBookLoanVO(bookLoanEntity);
    }
}
