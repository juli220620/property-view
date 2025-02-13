package com.github.juli220620.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {

    private Long id;
    private String name;
    private String brand;

    private PropertyAddressDto address;
    private PropertyContactDto contact;
    private PropertyArrivalTimeDto arrivalTime;
    private List<String> amenities;
}
