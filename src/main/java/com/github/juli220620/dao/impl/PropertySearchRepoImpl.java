package com.github.juli220620.dao.impl;

import com.github.juli220620.dao.PropertySearchRepo;
import com.github.juli220620.dao.impl.composite.ParamProcessor;
import com.github.juli220620.model.PropertyEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertySearchRepoImpl implements PropertySearchRepo {

    private final EntityManagerFactory entityManagerFactory;
    private final ParamProcessor paramProcessor;

    @Override
    public List<PropertyEntity> findAllByParams(List<SearchParam> params) {
        try(var entityManager = entityManagerFactory.createEntityManager()){
            var builder = entityManager.getCriteriaBuilder();
            var query = builder.createQuery(PropertyEntity.class);
            var root = query.from(PropertyEntity.class);

            List<Predicate> predicates = new ArrayList<>();

            params.forEach(it -> paramProcessor.process(it, builder, predicates, root, query));

            query.select(root).where(predicates.toArray(Predicate[]::new));
            return entityManager.createQuery(query).getResultList();
        }
    }
}