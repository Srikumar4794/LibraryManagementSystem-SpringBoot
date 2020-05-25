package com.projects.lms.dao;

import com.projects.lms.entity.FineEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFineDao extends CrudRepository<FineEntity, Long> {

    @Query("select f from FineEntity f inner join BookLoanEntity bl " +
            "on bl.loanId = f.loanId and f.paid = false " +
            "where bl.cardId = :cardId ")
    List<FineEntity> fetchFinesForCardId(@Param("cardId") Long cardId);
}
