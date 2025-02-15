package com.github.juli220620.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@Entity
@FieldNameConstants
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class PropertyAddressEntity {

    @Id
    private Long hotelId;

    @Range(min = 1)
    private Integer houseNumber;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String country;
    @NotBlank
    private String postCode;

}
