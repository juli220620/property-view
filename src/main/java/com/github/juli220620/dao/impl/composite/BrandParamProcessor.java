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
public class BrandParamProcessor extends AbstractPropertyParamProcessor {
    public static final String PARAM_NAME = "brand";

    private ParamProcessor next;

    @Override
    protected Path<Object> getPath(Root<PropertyEntity> root) {
        return root.get(PARAM_NAME);
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
