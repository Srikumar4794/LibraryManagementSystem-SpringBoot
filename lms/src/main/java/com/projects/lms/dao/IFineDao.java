package com.projects.lms.dao;

import com.projects.lms.entity.FineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFineDao extends CrudRepository<FineEntity, Long> {

}
