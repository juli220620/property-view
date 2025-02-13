package com.github.juli220620.dao;

import com.github.juli220620.dao.impl.SearchParam;
import com.github.juli220620.model.PropertyEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertySearchRepo {

    List<PropertyEntity> findAllByParams(List<SearchParam> params);
}
