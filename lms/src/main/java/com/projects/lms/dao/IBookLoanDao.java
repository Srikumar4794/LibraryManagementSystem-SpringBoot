package com.projects.lms.dao;

import com.projects.lms.entity.BookLoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookLoanDao extends JpaRepository<BookLoanEntity, Long>
{
    @Query("select b from BookLoanEntity b left join BorrowerEntity br " +
            " on b.cardId = br.cardId " +
            " where (:cardId is null or b.cardId = :cardId) " +
            " and (:bName = ' ' or b.borrowerEntity.borrowerName like concat('%', upper(:bName), '%')) " +
            " and (:isbn = ' ' or b.isbn = :isbn)")
    List<BookLoanEntity> fetchBookLoans(@Param("cardId") Long cardId, @Param("bName")String borrower, @Param("isbn") String isbn);
}
