package com.github.juli220620.dao.impl.composite;

import com.github.juli220620.dao.impl.SearchParam;
import com.github.juli220620.model.PropertyEntity;
import com.github.juli220620.service.PropertyParamKey;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public interface ParamProcessor {

    void process(SearchParam param,
                 CriteriaBuilder builder,
                 List<Predicate> predicates,
                 Root<PropertyEntity> root,
                 CriteriaQuery<PropertyEntity> query
    );

    PropertyParamKey paramKey();
}
