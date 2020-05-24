package com.projects.lms.dao;

import com.projects.lms.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorDao extends JpaRepository<AuthorEntity, Long> {

}
