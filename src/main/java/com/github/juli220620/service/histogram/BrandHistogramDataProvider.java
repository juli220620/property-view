package com.github.juli220620.service.histogram;

import com.github.juli220620.service.PropertyParamKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

import static com.github.juli220620.service.PropertyParamKey.BRAND;

@Component
public class BrandHistogramDataProvider extends AbstractHistogramDataProvider {

    public BrandHistogramDataProvider(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Query createQuery(EntityManager entityManager) {
        return entityManager.createQuery("select e.brand, count(e) from PropertyEntity e group by (e.brand)");
    }

    @Override
    public PropertyParamKey key() {
        return BRAND;
    }
}
