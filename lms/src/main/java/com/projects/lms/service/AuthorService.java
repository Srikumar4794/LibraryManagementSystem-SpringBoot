package com.projects.lms.service;

import com.projects.lms.dao.IAuthorDao;
import com.projects.lms.entity.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    IAuthorDao authorDAO;

    public List<AuthorEntity> getAllAuthors(){
        return authorDAO.findAll();
    }

    public AuthorEntity getAuthorById(Long authorId){
        if(authorId <= 0)
            throw new IllegalArgumentException("Invalid value for author ID");

        return authorDAO.findById(authorId).orElse(null);
    }

    public void addNewAuthor(AuthorEntity authorEntity){
        authorDAO.save(authorEntity);
    }

    public void updateAuthorName(Long authorId, String name){
        AuthorEntity current = authorDAO.findById(authorId).orElse(null);
        if(current != null){
            current.setAuthorName(name);
            authorDAO.save(current);
        }
        else{
            throw new IllegalArgumentException("Author ID does not exist");
        }
    }
}
