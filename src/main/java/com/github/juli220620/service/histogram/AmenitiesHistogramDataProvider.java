package com.github.juli220620.service.histogram;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class AmenitiesHistogramDataProvider extends AbstractHistogramDataProvider {
    public static final String KEY = "amenities";

    public AmenitiesHistogramDataProvider(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Query createQuery(EntityManager entityManager) {
        return entityManager.createQuery(
                "select a.name, count(e) " +
                "from AmenityEntity a, PropertyEntity e " +
                "where a member of e.amenities " +
                "group by (a.name)"
        );
    }

    @Override
    public String key() {
        return KEY;
    }
}
