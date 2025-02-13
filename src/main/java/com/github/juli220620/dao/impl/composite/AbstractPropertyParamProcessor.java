package com.github.juli220620.dao.impl.composite;

import com.github.juli220620.dao.impl.SearchParam;
import com.github.juli220620.model.PropertyEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public abstract class AbstractPropertyParamProcessor implements ParamProcessor {

    @Override
    public void process(SearchParam param,
                        CriteriaBuilder builder,
                        List<Predicate> predicates,
                        Root<PropertyEntity> root
    ) {
        if (param.getName().equals(getParamName())) {
            var variables = param.getValues().stream()
                    .map(it -> builder.equal(getPath(root), it))
                    .toList();
            predicates.add(builder.or(variables.toArray(new Predicate[]{})));
        }

        if (getNext() != null) getNext().process(param, builder, predicates, root);
    }

    protected abstract Path<Object> getPath(Root<PropertyEntity> root);
    protected abstract String getParamName();
    protected abstract ParamProcessor getNext();
}
