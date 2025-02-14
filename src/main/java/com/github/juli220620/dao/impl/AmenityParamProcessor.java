package com.github.juli220620.dao.impl;

import com.github.juli220620.model.AmenityEntity;
import com.github.juli220620.model.PropertyEntity;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AmenityParamProcessor  {
    public static final String PARAM_NAME = "amenities";

    public void process(SearchParam param,
                        CriteriaBuilder builder,
                        List<Predicate> predicates,
                        Root<PropertyEntity> root,
                        CriteriaQuery<PropertyEntity> query
    ) {
        if (param.getName().equals(PARAM_NAME)) {
            var subquery = query.subquery(Long.class);
            var subRoot = subquery.from(PropertyEntity.class);
            var join = subRoot.join(PropertyEntity.Fields.amenities, JoinType.INNER);

            var propertyIdPred = builder.equal(subRoot.get(PropertyEntity.Fields.id), root.get(PropertyEntity.Fields.id));
            var amenityIdPred = join.get(AmenityEntity.Fields.id).in(param.getValues());

            subquery.select(builder.count(join.get(AmenityEntity.Fields.id)))
                    .where(propertyIdPred, amenityIdPred);

            var subqueryPred = builder.equal(subquery, param.getValues().size());
            predicates.add(subqueryPred);
        }
    }
}
