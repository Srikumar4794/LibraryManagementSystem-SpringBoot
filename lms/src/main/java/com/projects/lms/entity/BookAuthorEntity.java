package com.projects.lms.entity;

import com.projects.lms.entity.compositeKeys.BookAuthorCompositeKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "book_authors")
@Data
@IdClass(BookAuthorCompositeKey.class)
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthorEntity {
    @Id
    @Column(name = "isbn")
    private String isbn;

    @Id
    @Column(name = "author_id")
    private Long authorId;

    @JoinColumn(name = "author_id", referencedColumnName = "author_id", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private AuthorEntity authorEntity;

    @JoinColumn(name = "isbn", referencedColumnName = "isbn", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private BookEntity bookEntity;
}
