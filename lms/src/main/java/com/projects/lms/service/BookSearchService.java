/*
package com.projects.lms.service;

import com.projects.lms.dao.IAuthorDao;
import com.projects.lms.dao.IBookAuthorDao;
import com.projects.lms.dao.IBookDao;
import com.projects.lms.dao.IBookSearchDao;
import com.projects.lms.entity.BookAuthorSearch;
import com.projects.lms.vo.BookSearchResultVO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class BookSearchService {
    private final IAuthorDao authorDao;
    private final IBookDao bookDao;
    private final IBookAuthorDao bookAuthorDao;

    private final IBookSearchDao bookSearchDao;

    public List<BookSearchResultVO> getAllBooks(String searchText) {
        String[] words = searchText.split(" ");
        List<BookSearchResultVO> searchResultList = new ArrayList<>();
        for(String word: words){
            List<BookAuthorSearch> bookAuthorSearches = bookSearchDao.fetchBooksAndAuthorsBySearchTerm(searchText);

        }
        return new ArrayList<>();
    }
}
*/
