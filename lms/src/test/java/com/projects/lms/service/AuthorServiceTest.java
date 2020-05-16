package com.projects.lms.service;

import com.projects.lms.entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorServiceTest {
    @Autowired
    private AuthorService authorService;

    @Test
    void testGetAuthorById() {
        Author author = new Author();
        author.setAuthorId(1L);
        author.setAuthorName("Bel Kaufman");
        assertEquals(author, authorService.getAuthorById(1L), "Service to get author details by authorId");
        assertNull(authorService.getAuthorById(1568850L));
        assertNotEquals(author, authorService.getAuthorById(7L));
        assertThrows(IllegalArgumentException.class, () -> authorService.getAuthorById(-1L), "Unexpected exception returned.");
    }

    @Test
    void addNewAuthor() {
    }
}