package com.projects.lms.translator;

import com.projects.lms.entity.FineEntity;
import com.projects.lms.vo.FineVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IFineTranslator {
    @Mapping(target = "isbn", source = "fineEntity.bookLoanEntity.isbn")
    @Mapping(target = "bookName", source = "fineEntity.bookLoanEntity.bookEntity.title")
    @Mapping(target = "cardId", source = "fineEntity.bookLoanEntity.cardId")
    FineVO toFineVO(FineEntity fineEntity);

    List<FineVO> toFineVOList(List<FineEntity> fineEntityList);
}
