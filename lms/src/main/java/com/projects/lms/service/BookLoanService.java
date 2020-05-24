package com.projects.lms.service;

import com.projects.lms.dao.IBookLoanDao;
import com.projects.lms.dto.BookLoanDTO;
import com.projects.lms.entity.BookLoanEntity;
import com.projects.lms.translator.IBookLoanTranslator;
import com.projects.lms.vo.BookLoanVO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                        .dateIn(new Date())
                        .build();

        return bookLoanTranslator.toBookLoanVO(bookLoanDao.save(bookLoanEntity));
    }
}
