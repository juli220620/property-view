package com.github.juli220620.dao.impl.composite;

import com.github.juli220620.dao.impl.SearchParam;
import com.github.juli220620.model.PropertyEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public abstract class AbstractPropertyParamProcessor extends ComposingPropertyParamProcessor {

    @Override
    public void doProcess(SearchParam param,
                        CriteriaBuilder builder,
                        List<Predicate> predicates,
                        Root<PropertyEntity> root,
                        CriteriaQuery<PropertyEntity> query
    ) {
        var searchVariables = param.getValues().stream()
                .map(value -> processParam(param.getName(), builder, root, query))
                .toList();
        predicates.add(builder.or(searchVariables.toArray(new Predicate[]{})));
    }

    protected abstract Predicate processParam(String param,
                                              CriteriaBuilder builder,
                                              Root<PropertyEntity> root,
                                              CriteriaQuery<PropertyEntity> query);

}
