package com.projects.lms.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookSearchResultVO {
    private String isbn;
    private String title;
    private String author;
    private String availability;
}
