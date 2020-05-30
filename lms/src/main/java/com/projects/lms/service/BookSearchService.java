package com.projects.lms.service;

import com.projects.lms.dao.IAuthorDao;
import com.projects.lms.dao.IBookAuthorDao;
import com.projects.lms.dao.IBookDao;
import com.projects.lms.dao.IBookSearchDao;
import com.projects.lms.entity.BookSearchEntity;
import com.projects.lms.translator.IBookSearchTranslator;
import com.projects.lms.vo.BookSearchVO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IBookSearchTranslator bookSearchTranslator;

    //TODO Handle scenario where each book has multiple authors.
    public List<BookSearchVO> getAllBooks(String searchText) {
        String[] words = searchText.split(" ");
        //List<BookSearchResultVO> searchResultList = new ArrayList<>();
        Set<BookSearchEntity> bookAuthorSearches = new HashSet<>();
        for(String word: words){
            bookAuthorSearches.addAll(bookSearchDao.fetchBooksWithBookAuthorsBySearchTerm(word));
            bookAuthorSearches.addAll(bookSearchDao.fetchAuthorsWithBookAuthorsBySearchTerm(word));
        }
        return bookSearchTranslator.toBookSearchVOList(bookAuthorSearches);
    }
}
