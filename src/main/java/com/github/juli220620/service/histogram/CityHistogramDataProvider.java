package com.github.juli220620.service.histogram;

import com.github.juli220620.service.PropertyParamKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

import static com.github.juli220620.service.PropertyParamKey.CITY;

@Component
public class CityHistogramDataProvider extends AbstractHistogramDataProvider {

    public CityHistogramDataProvider(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Query createQuery(EntityManager entityManager) {
        return entityManager.createQuery(
                "select a.city, count(a) from PropertyAddressEntity a group by (a.city)");
    }

    @Override
    public PropertyParamKey key() {
        return CITY;
    }
}
