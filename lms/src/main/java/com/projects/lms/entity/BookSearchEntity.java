package com.projects.lms.entity;

import com.projects.lms.entity.compositeKeys.BookAuthorCompositeKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@IdClass(BookAuthorCompositeKey.class)
@AllArgsConstructor
@NoArgsConstructor
public class BookSearchEntity {
    @Id
    @Column(name = "author_id")
    private Long authorId;

    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "name")
    private String authorName;

    @Column(name = "date_in")
    private Date date_in;

    @Column(name = "date_out")
    private Date date_out;
}
