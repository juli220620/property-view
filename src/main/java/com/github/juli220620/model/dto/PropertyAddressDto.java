package com.github.juli220620.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyAddressDto {

    private Integer houseNumber;
    private String street;
    private String city;
    private String country;
    private String postCode;
}
