package com.github.juli220620.dao.impl.composite;

import com.github.juli220620.model.PropertyAddressEntity;
import com.github.juli220620.model.PropertyEntity;
import com.github.juli220620.service.PropertySearchKey;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CountryParamProcessor extends AbstractPropertyParamProcessor {

    @Override
    protected Predicate processParam(String param, CriteriaBuilder builder, Root<PropertyEntity> root, CriteriaQuery<PropertyEntity> query) {
        return builder.equal(root.get(PropertyEntity.Fields.address).get(PropertyAddressEntity.Fields.country), param);
    }

    @Override
    public PropertySearchKey paramKey() {
        return PropertySearchKey.COUNTRY;
    }
}
