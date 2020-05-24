package com.projects.lms.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class BookSearchVO {
    private Long authorId;
    private String isbn;
    private String title;
    private String authorName;
    private Date date_in;
    private Date date_out;
}
