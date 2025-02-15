package com.github.juli220620.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Entity
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "amenity")
public class AmenityEntity {
    @Id
    private String name;
}
