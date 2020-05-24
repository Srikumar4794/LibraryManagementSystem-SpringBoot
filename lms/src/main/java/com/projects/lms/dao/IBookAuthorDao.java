package com.projects.lms.dao;

import com.projects.lms.entity.compositeKeys.BookAuthorCompositeKey;
import com.projects.lms.entity.BookAuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookAuthorDao extends JpaRepository<BookAuthorEntity, BookAuthorCompositeKey> {
}
