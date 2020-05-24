package com.projects.lms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "authors")
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {
    @Id
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "name")
    private String authorName;
}
