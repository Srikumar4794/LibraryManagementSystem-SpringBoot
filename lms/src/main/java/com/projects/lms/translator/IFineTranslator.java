package com.projects.lms.translator;

import com.projects.lms.entity.FineEntity;
import com.projects.lms.vo.FineVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IFineTranslator {

    FineVO toFineVO(FineEntity fineEntity);

    List<FineVO> toFineVOList(List<FineEntity> fineEntityList);
}
