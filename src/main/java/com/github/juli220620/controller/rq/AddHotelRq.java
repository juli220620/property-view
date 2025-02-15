package com.github.juli220620.controller.rq;

import com.github.juli220620.model.dto.PropertyAddressDto;
import com.github.juli220620.model.dto.PropertyArrivalTimeDto;
import com.github.juli220620.model.dto.PropertyContactDto;
import lombok.Getter;

@Getter
public class AddHotelRq {

    private String name;
    private String description;
    private String brand;

    private PropertyAddressDto address;
    private PropertyContactDto contacts;
    private PropertyArrivalTimeDto arrivalTime;


}
