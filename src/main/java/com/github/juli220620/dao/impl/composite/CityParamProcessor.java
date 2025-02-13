package com.github.juli220620.dao.impl.composite;

import com.github.juli220620.model.PropertyEntity;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class CityParamProcessor extends AbstractPropertyParamProcessor {
    public static final String PARAM_NAME = "city";
    public static final String NESTED_ENTITY_NAME = "address";

    private ParamProcessor next;


    @Override
    protected Path<Object> getPath(Root<PropertyEntity> root) {
        return root.get(NESTED_ENTITY_NAME).get(PARAM_NAME);
    }

    @Override
    protected String getParamName() {
        return PARAM_NAME;
    }

    @Override
    protected ParamProcessor getNext() {
        return next;
    }
}
