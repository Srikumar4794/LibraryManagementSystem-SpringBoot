package com.projects.lms.translator;

import com.projects.lms.entity.BookLoanEntity;
import com.projects.lms.service.BookLoanService;
import com.projects.lms.vo.BookLoanVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBookLoanTranslator {

    @Mapping(target = "borrowerName", source = "bookLoanEntity.borrowerEntity.borrowerName")
    BookLoanVO toBookLoanVO(BookLoanEntity bookLoanEntity);

    List<BookLoanVO> toBookLoanVOList(List<BookLoanEntity> bookLoanEntityList);
}
