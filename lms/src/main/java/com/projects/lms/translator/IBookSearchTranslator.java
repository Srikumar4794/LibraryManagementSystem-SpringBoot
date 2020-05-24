package com.projects.lms.translator;

import com.projects.lms.entity.BookSearchEntity;
import com.projects.lms.vo.BookSearchVO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface IBookSearchTranslator {
    BookSearchVO toBookSearchVO(BookSearchEntity bookSearchEntity);

    List<BookSearchVO> toBookSearchVOList(Set<BookSearchEntity> bookSearchEntityList);
}
