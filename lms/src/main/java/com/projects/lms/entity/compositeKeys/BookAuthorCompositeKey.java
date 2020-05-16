package com.projects.lms.entity.compositeKeys;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BookAuthorCompositeKey implements Serializable {
    private String isbn;
    private Long authorId;
}
