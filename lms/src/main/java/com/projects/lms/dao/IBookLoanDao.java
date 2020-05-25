package com.projects.lms.dao;

import com.projects.lms.entity.BookLoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.prefs.BackingStoreException;

@Repository
public interface IBookLoanDao extends JpaRepository<BookLoanEntity, Long>
{
    @Query("select b from BookLoanEntity b left join BorrowerEntity br " +
            " on b.cardId = br.cardId " +
            " where (:cardId is null or b.cardId = :cardId) " +
            " and (:bName = ' ' or b.borrowerEntity.borrowerName like concat('%', upper(:bName), '%')) " +
            " and (:isbn = ' ' or b.isbn = :isbn)")
    List<BookLoanEntity> fetchBookLoans(@Param("cardId") Long cardId, @Param("bName")String borrower, @Param("isbn") String isbn);

    Integer countAllByDateInIsNullAndDateOutIsNotNullAndCardId(Long cardId);

    Boolean existsByDateInIsNullAndDateOutIsNotNullAndIsbn(String isbn);

    @Query("select bl from BookLoanEntity bl inner join FineEntity f " +
            " on bl.loanId = f.loanId and f.paid = false " +
            " where (bl.dueDate < current_date or bl.dateIn > bl.dueDate) "
            )
    List<BookLoanEntity> fetchBookLoansWithExistingFines();

    @Query("  select bl from BookLoanEntity bl" +
            " where (bl.dueDate < current_date or bl.dateIn > bl.dueDate)" +
            " and bl.loanId not in " +
            " (select f.loanId from FineEntity f)")
    List<BookLoanEntity> fetchBookLoansEligibleForFines();

    Boolean existsByDateInIsNullAndDateOutIsNotNullAndLoanId(Long loanId);
}
