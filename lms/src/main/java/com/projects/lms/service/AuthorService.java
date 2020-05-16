package com.projects.lms.service;

import com.projects.lms.dao.IAuthorDao;
import com.projects.lms.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InvalidClassException;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    IAuthorDao authorDAO;

    public List<Author> getAllAuthors(){
        return authorDAO.findAll();
    }

    public Author getAuthorById(Long authorId){
        if(authorId <= 0)
            throw new IllegalArgumentException("Invalid value for author ID");

        return authorDAO.findById(authorId).orElse(null);
    }

    public void addNewAuthor(Author author){
        authorDAO.save(author);
    }

    public void updateAuthorName(Long authorId, String name){
        Author current = authorDAO.findById(authorId).orElse(null);
        if(current != null){
            current.setAuthorName(name);
            authorDAO.save(current);
        }
        else{
            throw new IllegalArgumentException("Author ID does not exist");
        }
    }
}
