package com.github.juli220620.dao.impl.composite;

import com.github.juli220620.dao.impl.SearchParam;
import com.github.juli220620.model.AmenityEntity;
import com.github.juli220620.model.PropertyEntity;
import com.github.juli220620.service.PropertySearchKey;
import jakarta.persistence.criteria.*;

import java.util.List;

public class AmenityParamProcessor extends ComposingPropertyParamProcessor {

    @Override
    public PropertySearchKey paramKey() {
        return PropertySearchKey.AMENITY;
    }

    @Override
    protected void doProcess(
            SearchParam param,
            CriteriaBuilder builder,
            List<Predicate> predicates,
            Root<PropertyEntity> root,
            CriteriaQuery<PropertyEntity> query
    ) {
        var subquery = query.subquery(Long.class);
        var subRoot = subquery.from(PropertyEntity.class);
        var join = subRoot.join(PropertyEntity.Fields.amenities, JoinType.INNER);

        var propertyIdPred = builder.equal(subRoot.get(PropertyEntity.Fields.id), root.get(PropertyEntity.Fields.id));
        var amenityIdPred = join.get(AmenityEntity.Fields.name).in(param.getValues());

        subquery.select(builder.count(join.get(AmenityEntity.Fields.name)))
                .where(propertyIdPred, amenityIdPred);

        predicates.add(builder.equal(subquery, param.getValues().size()));
    }
}
