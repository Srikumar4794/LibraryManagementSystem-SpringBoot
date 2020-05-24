package com.projects.lms.dao;

import com.projects.lms.entity.BorrowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowerDao extends JpaRepository<BorrowerEntity, Long> {

    Boolean existsBySsnEquals(String ssn);
}
