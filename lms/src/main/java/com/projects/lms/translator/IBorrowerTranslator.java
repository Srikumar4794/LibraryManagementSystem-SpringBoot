package com.projects.lms.translator;

import com.projects.lms.entity.BorrowerEntity;
import com.projects.lms.vo.BorrowerVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBorrowerTranslator {

    BorrowerVO toBorrowerVO(BorrowerEntity borrowerEntity);

    List<BorrowerVO> toBorrowerVOList(List<BorrowerEntity> borrowerEntityList);

    BorrowerEntity toBorrowerEntity(BorrowerVO borrowerVO);
}
