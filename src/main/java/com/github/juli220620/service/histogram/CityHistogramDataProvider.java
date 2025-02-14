package com.github.juli220620.service.histogram;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class CityHistogramDataProvider extends AbstractHistogramDataProvider {
    public static final String KEY = "city";

    public CityHistogramDataProvider(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Query createQuery(EntityManager entityManager) {
        return entityManager.createQuery(
                "select a.city, count(a) from PropertyAddressEntity a group by (a.city)");
    }

    @Override
    public String key() {
        return KEY;
    }
}
