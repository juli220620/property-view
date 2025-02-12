package com.github.juli220620.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "amenity")
public class AmenityEntity {

    @Id
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private String id;

    private String name;
}
