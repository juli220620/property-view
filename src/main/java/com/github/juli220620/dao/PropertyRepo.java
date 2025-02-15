package com.github.juli220620.dao;

import com.github.juli220620.model.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepo extends JpaRepository<PropertyEntity,Long>, PropertySearchRepo {}
