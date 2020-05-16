package com.projects.lms.controller;

import com.projects.lms.entity.Author;
import com.projects.lms.service.AuthorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping(value = "/api/authors")
    public List<Author> getAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping(value = "/api/author/{authorId}")
    public Author getAuthor(@PathVariable Long authorId){
        return authorService.getAuthorById(authorId);
    }

    @PostMapping(value = "/api/author")
    public void addAuthor(@RequestBody Author author){
        authorService.addNewAuthor(author);
    }

    @PutMapping(value = "/api/author/{authorId}")
    public void updateAuthor(@PathVariable Long authorId, @RequestBody String authorName){
        authorService.updateAuthorName(authorId, authorName);
    }
}
