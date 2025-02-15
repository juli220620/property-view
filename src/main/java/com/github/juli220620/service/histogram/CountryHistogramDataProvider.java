package com.github.juli220620.service.histogram;

import com.github.juli220620.service.PropertyParamKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

import static com.github.juli220620.service.PropertyParamKey.COUNTRY;

@Component
public class CountryHistogramDataProvider extends AbstractHistogramDataProvider {

    public CountryHistogramDataProvider(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Query createQuery(EntityManager entityManager) {
        return entityManager.createQuery(
                "select a.country, count(a) from PropertyAddressEntity a group by (a.country)");
    }

    @Override
    public PropertyParamKey key() {
        return COUNTRY;
    }
}
