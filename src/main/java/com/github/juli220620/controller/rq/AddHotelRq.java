package com.github.juli220620.controller.rq;

import com.github.juli220620.model.dto.PropertyAddressDto;
import com.github.juli220620.model.dto.PropertyArrivalTimeDto;
import com.github.juli220620.model.dto.PropertyContactDto;

public record AddHotelRq(String name,
                         String description,
                         String brand,
                         PropertyAddressDto address,
                         PropertyContactDto contacts,
                         PropertyArrivalTimeDto arrivalTime) { }
