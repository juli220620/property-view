package com.github.juli220620.controller.rq;

import com.github.juli220620.model.dto.PropertyAddressDto;
import com.github.juli220620.model.dto.PropertyArrivalTimeDto;
import com.github.juli220620.model.dto.PropertyContactDto;
 import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AddHotelRq {

    private final String name;
    private final String description;
    private final String brand;

    private final PropertyAddressDto address;
    private final PropertyContactDto contacts;
    private final PropertyArrivalTimeDto arrivalTime;


}
