package com.github.juli220620.service.histogram;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractHistogramDataProvider implements HistogramDataProvider {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<Object[]> provide() {
        try(var entityManager = entityManagerFactory.createEntityManager()) {
            return createQuery(entityManager).getResultList();
        }
    }

    protected abstract Query createQuery(EntityManager entityManager);
}
