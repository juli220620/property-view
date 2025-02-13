package com.github.juli220620.dao.impl.composite;

import com.github.juli220620.dao.impl.SearchParam;
import com.github.juli220620.model.PropertyEntity;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class AmenityParamProcessor implements ParamProcessor {
    public static final String PARAM_NAME = "amenity";
    public static final String NESTED_ENTITY_NAME = "amenities";

    private ParamProcessor next;

    @Override
    public void process(SearchParam param,
                        CriteriaBuilder builder,
                        List<Predicate> predicates,
                        Root<PropertyEntity> root
    ) {
        if (param.getName().equals(PARAM_NAME)) {
            root.fetch(NESTED_ENTITY_NAME, JoinType.RIGHT);

            var variables = param.getValues().stream()
                    .map(it -> builder.equal(root.get(NESTED_ENTITY_NAME).get("id"), it))
                    .toList();
            predicates.add(builder.or(variables.toArray(new Predicate[]{})));
        }

        if (next != null) next.process(param, builder, predicates, root);
    }
}
