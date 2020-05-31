package com.projects.lms.service;

import com.projects.lms.dao.IBookLoanDao;
import com.projects.lms.dto.BookLoanDTO;
import com.projects.lms.entity.BookLoanEntity;
import com.projects.lms.translator.IBookLoanTranslator;
import com.projects.lms.utils.LibraryDateUtils;
import com.projects.lms.vo.BookLoanVO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

import static com.projects.lms.utils.Constants.MAX_BOOK_LOANS_ALLOWED;

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
        if(!isBookLoanPermitted(bookLoanDTO.getCardId())){
            throw new IllegalArgumentException("Error! " + MAX_BOOK_LOANS_ALLOWED + " books checked-out already by " + bookLoanDTO.getCardId());
        }

        if(isBookAlreadyCheckedOut(bookLoanDTO.getIsbn())){
            throw new IllegalArgumentException("Book with ISBN " + bookLoanDTO.getIsbn() + " has already been checked out");
        }

        BookLoanEntity bookLoanEntity = BookLoanEntity.builder()
                        .isbn(bookLoanDTO.getIsbn())
                        .cardId(bookLoanDTO.getCardId())
                        .dateOut(new Date())
                        .dueDate(LibraryDateUtils.findDueDate(new Date()))
                        .build();

        return bookLoanTranslator.toBookLoanVO(bookLoanDao.save(bookLoanEntity));
    }

    private boolean isBookAlreadyCheckedOut(String isbn) {
        return bookLoanDao.existsByDateInIsNullAndDateOutIsNotNullAndIsbn(isbn);
    }

    private boolean isBookLoanPermitted(Long cardId) {
        Integer existingLoans = bookLoanDao.countAllByDateInIsNullAndDateOutIsNotNullAndCardId(cardId);
        return MAX_BOOK_LOANS_ALLOWED.compareTo(existingLoans) > 0;
    }

    public BookLoanVO checkInBook(Long loanId) {
        BookLoanEntity bookLoanEntity = bookLoanDao.findById(loanId).orElseThrow(() -> new IllegalArgumentException("No book loans found for loan id: "));

        bookLoanEntity.setDateIn(new Date());
        bookLoanDao.save(bookLoanEntity);
        return bookLoanTranslator.toBookLoanVO(bookLoanEntity);
    }

    public List<BookLoanVO> getAllBookLoans() {
        return bookLoanTranslator.toBookLoanVOList(bookLoanDao.findAll());
    }
}
