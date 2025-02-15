package com.github.juli220620.dao.impl.composite;

import com.github.juli220620.model.PropertyEntity;
import com.github.juli220620.service.PropertySearchKey;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class BrandParamProcessor extends AbstractPropertyParamProcessor {

    @Override
    protected Predicate processParam(String value, CriteriaBuilder builder, Root<PropertyEntity> root, CriteriaQuery<PropertyEntity> query) {
        return builder.equal(root.get(PropertyEntity.Fields.brand), value);
    }

    @Override
    public PropertySearchKey paramKey() {
        return PropertySearchKey.BRAND;
    }
}
