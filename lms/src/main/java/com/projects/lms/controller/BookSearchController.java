package com.projects.lms.controller;

import com.projects.lms.entity.BookSearchEntity;
import com.projects.lms.service.BookSearchService;
import com.projects.lms.vo.BookSearchVO;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
public class BookSearchController {
    private final BookSearchService bookSearchService;

    @GetMapping(path = "/api/v1/search/{searchText}")
    private List<BookSearchVO> searchBooks(@PathVariable("searchText") String searchText){
        return bookSearchService.getAllBooks(searchText);
    }
}
