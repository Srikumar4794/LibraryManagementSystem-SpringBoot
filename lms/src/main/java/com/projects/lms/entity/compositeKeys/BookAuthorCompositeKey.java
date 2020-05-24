package com.projects.lms.entity.compositeKeys;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class BookAuthorCompositeKey implements Serializable {
    public String isbn;
    public Long authorId;
}
