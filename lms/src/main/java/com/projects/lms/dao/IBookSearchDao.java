/*
package com.projects.lms.dao;

import com.projects.lms.entity.BookAuthorSearch;
import com.projects.lms.entity.compositeKeys.BookAuthorCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookSearchDao extends JpaRepository<BookAuthorSearch, BookAuthorCompositeKey> {

    @Query(value = "(SELECT B.ISBN, A.NAME, B.TITLE " +
            "FROM BOOK B INNER JOIN BOOK_AUTHORS BA " +
            "ON B.ISBN = BA.ISBN " +
            "AND (B.ISBN LIKE %:searchStr% OR B.TITLE LIKE %:searchStr) " +
            "INNER JOIN AUTHORS A " +
            "ON A.AUTHOR_ID = BA.AUTHOR_ID) " +
            "UNION " +
            "(SELECT BA.ISBN, A.NAME,B.TITLE " +
            "FROM BOOK_AUTHORS BA INNER JOIN AUTHORS A " +
            "ON BA.AUTHOR_ID = A.AUTHOR_ID " +
            "AND A.NAME LIKE %:searchStr% " +
            "INNER JOIN BOOK B " +
            "ON B.ISBN = BA.ISBN) ", nativeQuery = true)
    List<BookAuthorSearch> fetchBooksAndAuthorsBySearchTerm(@Param("searchStr") String searchTerm);
}
*/
