package com.projects.lms.dao;

import com.projects.lms.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookDao extends JpaRepository<BookEntity, String> {
}
