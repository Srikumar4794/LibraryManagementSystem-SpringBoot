package com.projects.lms.service;

import com.projects.lms.dao.IAuthorDao;
import com.projects.lms.dao.IBookAuthorDao;
import com.projects.lms.dao.IBookDao;
import com.projects.lms.dao.IBookSearchDao;
import com.projects.lms.entity.BookSearchEntity;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Data
public class BookSearchService {
    private final IAuthorDao authorDao;
    private final IBookDao bookDao;
    private final IBookAuthorDao bookAuthorDao;

    private final IBookSearchDao bookSearchDao;

    public List<BookSearchEntity> getAllBooks(String searchText) {
        String[] words = searchText.split(" ");
        //List<BookSearchResultVO> searchResultList = new ArrayList<>();
        Set<BookSearchEntity> bookAuthorSearches = new HashSet<>();
        for(String word: words){
            bookAuthorSearches.addAll(bookSearchDao.fetchBooksWithBookAuthorsBySearchTerm(word));
            bookAuthorSearches.addAll(bookSearchDao.fetchAuthorsWithBookAuthorsBySearchTerm(word));
        }
        return new ArrayList<>(bookAuthorSearches);
    }
}
