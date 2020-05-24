package com.projects.lms.controller;

import com.projects.lms.entity.AuthorEntity;
import com.projects.lms.service.AuthorService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping(value = "/api/v1/authors")
    public List<AuthorEntity> getAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping(value = "/api/v1/author/{authorId}")
    public AuthorEntity getAuthor(@PathVariable Long authorId){
        return authorService.getAuthorById(authorId);
    }

    @PostMapping(value = "/api/v1/author")
    public void addAuthor(@RequestBody AuthorEntity authorEntity){
        authorService.addNewAuthor(authorEntity);
    }

    @PutMapping(value = "/api/v1/author/{authorId}")
    public void updateAuthor(@PathVariable Long authorId, @RequestBody String authorName){
        authorService.updateAuthorName(authorId, authorName);
    }
}
