package com.github.juli220620.service.histogram;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class CountryHistogramDataProvider extends AbstractHistogramDataProvider {
    public static final String KEY = "country";

    public CountryHistogramDataProvider(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Query createQuery(EntityManager entityManager) {
        return entityManager.createQuery(
                "select a.country, count(a) from PropertyAddressEntity a group by (a.country)");
    }

    @Override
    public String key() {
        return KEY;
    }
}
