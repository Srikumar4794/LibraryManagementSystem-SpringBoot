package com.projects.lms.service;

import com.projects.lms.entity.AuthorEntity;
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
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setAuthorId(1L);
        authorEntity.setAuthorName("Bel Kaufman");
        assertEquals(authorEntity, authorService.getAuthorById(1L), "Service to get author details by authorId");
        assertNull(authorService.getAuthorById(1568850L));
        assertNotEquals(authorEntity, authorService.getAuthorById(7L));
        //assertThrows(IllegalArgumentException.class, () -> authorService.getAuthorById(-1L), "Unexpected exception returned.");
    }

    @Test
    void addNewAuthor() {
    }
}