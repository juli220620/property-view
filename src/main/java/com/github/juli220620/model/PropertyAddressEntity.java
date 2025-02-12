package com.github.juli220620.model;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class PropertyAddressEntity {

    @Id
    private Long hotelId;

    private Long houseNumber;
    private String street;
    private String city;
    private String state;
    private String postCode;

}
