package com.github.juli220620.service.histogram;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class BrandHistogramDataProvider extends AbstractHistogramDataProvider {
    public static final String KEY = "brand";

    public BrandHistogramDataProvider(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Query createQuery(EntityManager entityManager) {
        return entityManager.createQuery("select e.brand, count(e) from PropertyEntity e group by (e.brand)");
    }

    @Override
    public String key() {
        return KEY;
    }
}
