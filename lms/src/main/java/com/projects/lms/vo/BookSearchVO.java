package com.projects.lms.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSearchVO {
    private String isbn;
    private String title;
    private String authorName;
    private Boolean availability;
}
