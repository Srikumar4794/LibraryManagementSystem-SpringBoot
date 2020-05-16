/*
package com.projects.lms.controller;

import com.projects.lms.service.BookSearchService;
import com.projects.lms.vo.BookSearchResultVO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
public class BookSearchController {
    private final BookSearchService bookSearchService;

    @GetMapping(path = "/api/search/{searchText}")
    private List<BookSearchResultVO> searchBooks(@PathVariable("searchText") String searchText){
        return bookSearchService.getAllBooks(searchText);
    }
}
*/
