package com.github.juli220620.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@FieldNameConstants
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "property")
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String brand;
    private String description;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "hotel", optional = false)
    private PropertyAddressEntity address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "hotel", optional = false)
    private PropertyContactEntity contact;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "hotel", optional = false)
    private PropertyArrivalTimeEntity arrivalTime;

    @ManyToMany(cascade = {PERSIST, REFRESH, DETACH})
    @JoinTable(
            name = "property_amenities",
            joinColumns = @JoinColumn(name = "property_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id", referencedColumnName = "name")
    )
    private List<AmenityEntity> amenities;
}