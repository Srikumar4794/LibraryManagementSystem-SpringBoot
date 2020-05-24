package com.projects.lms.dao;

import com.projects.lms.entity.BookSearchEntity;
import com.projects.lms.entity.compositeKeys.BookAuthorCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookSearchDao extends JpaRepository<BookSearchEntity, BookAuthorCompositeKey> {

    @Query("SELECT new BookSearchEntity(ba.authorId, b.isbn, b.title, a.authorName) from BookEntity b inner join BookAuthorEntity ba" +
            " on b.isbn = ba.isbn inner join AuthorEntity a on a.authorId = ba.authorId where " +
            " (b.isbn like concat('%', UPPER(:searchStr), '%') or b.title like concat('%', UPPER(:searchStr), '%')" +
            " or a.authorName like concat('%', UPPER(:searchStr), '%'))")
    List<BookSearchEntity> fetchBooksWithBookAuthorsBySearchTerm(@Param("searchStr") String searchStr);

    @Query("SELECT new BookSearchEntity(a.authorId, b.isbn, b.title, a.authorName) from AuthorEntity a inner join BookAuthorEntity ba" +
            " on a.authorId = ba.authorId inner join BookEntity b on b.isbn = ba.isbn where " +
            " (b.isbn like concat('%', UPPER(:searchStr), '%') or b.title like concat('%', UPPER(:searchStr), '%')" +
            " or a.authorName like concat('%', UPPER(:searchStr), '%'))")
    List<BookSearchEntity> fetchAuthorsWithBookAuthorsBySearchTerm(@Param("searchStr") String searchStr);
}
