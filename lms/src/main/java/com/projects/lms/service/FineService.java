package com.projects.lms.service;

import com.projects.lms.dao.IBookLoanDao;
import com.projects.lms.dao.IFineDao;
import com.projects.lms.dto.BookLoanDTO;
import com.projects.lms.entity.BookLoanEntity;
import com.projects.lms.entity.FineEntity;
import com.projects.lms.translator.IFineTranslator;
import com.projects.lms.utils.LibraryDateUtils;
import com.projects.lms.vo.FineVO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.projects.lms.utils.Constants.FINE_PER_DAY;

@Service
@Data
public class FineService
{
    private final IFineDao fineDao;
    private final IBookLoanDao bookLoanDao;

    @Autowired
    private IFineTranslator fineTranslator;

    public void updateFines()
    {
        List<BookLoanEntity> bookLoanEntities = bookLoanDao.fetchBookLoansWithExistingFines();
        bookLoanEntities.addAll(bookLoanDao.fetchBookLoansEligibleForFines());
        List<FineEntity> fineEntities = new ArrayList<>();

        bookLoanEntities.forEach(bookLoanEntity -> {
            FineEntity fineEntity = FineEntity.builder()
                    .loanId(bookLoanEntity.getLoanId())
                    .paid(false)
                    .fineAmount(calculateFineAmount(bookLoanEntity.getDueDate()))
                    .build();

            fineEntities.add(fineEntity);
        });

        fineDao.saveAll(fineEntities);
    }

    public FineVO updateFine(Long loanId, BookLoanDTO bookLoanDTO)
    {
        FineEntity fineEntity = fineDao.findById(loanId).orElseThrow(() -> new IllegalArgumentException("Fine does not exist for book with ISBN: " + bookLoanDTO.getIsbn()));

        if(isBookNotReturned(loanId))
            throw new IllegalArgumentException("Book with ISBN " + bookLoanDTO.getIsbn() + " has not yet been returned" );

        fineEntity.setFineAmount(0.00);
        fineEntity.setPaid(true);

        return fineTranslator.toFineVO(fineDao.save(fineEntity));
    }

    private boolean isBookNotReturned(Long loanId) {
        return bookLoanDao.existsByDateInIsNullAndDateOutIsNotNullAndLoanId(loanId);
    }

    private Double calculateFineAmount(Date dueDate)
    {
        return Math.abs(FINE_PER_DAY * LibraryDateUtils.findDaysElapsed(dueDate));
    }

    public List<FineVO> getFinesByCardId(Long cardId) {
        return fineTranslator.toFineVOList(fineDao.fetchFinesForCardId(cardId));
    }
}
