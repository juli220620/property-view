package com.github.juli220620.service.histogram;

import com.github.juli220620.service.PropertyParamKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

import static com.github.juli220620.service.PropertyParamKey.AMENITY;

@Component
public class AmenitiesHistogramDataProvider extends AbstractHistogramDataProvider {

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
    public PropertyParamKey key() {
        return AMENITY;
    }
}
