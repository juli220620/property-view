package com.github.juli220620.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "property")
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private PropertyAddressEntity address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private PropertyContactEntity contact;

    @ManyToMany
    @JoinTable(
            name = "property_amenities",
            joinColumns = @JoinColumn(name = "property_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id", referencedColumnName = "id")
    )
    private List<AmenityEntity> amenities;
}
