package com.github.juli220620.dao.impl.composite;

import com.github.juli220620.dao.impl.SearchParam;
import com.github.juli220620.model.PropertyEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public abstract class ComposingPropertyParamProcessor implements PropertyParamProcessorComposite{
    private ParamProcessor next;

    @Override
    public void process(SearchParam param,
                        CriteriaBuilder builder,
                        List<Predicate> predicates,
                        Root<PropertyEntity> root,
                        CriteriaQuery<PropertyEntity> query
    ) {
        if (!paramKey().getValue().equals(param.getName())) {
            Optional.ofNullable(next)
                    .ifPresent(it -> it.process(param, builder, predicates, root, query));
            return;
        }

        doProcess(param, builder, predicates, root, query);
    }

    @Override
    public PropertyParamProcessorComposite compose(PropertyParamProcessorComposite composite) {
        this.next = composite;
        return composite;
    }

    protected abstract void doProcess(
            SearchParam param,
            CriteriaBuilder builder,
            List<Predicate> predicates,
            Root<PropertyEntity> root,
            CriteriaQuery<PropertyEntity> query);
}
