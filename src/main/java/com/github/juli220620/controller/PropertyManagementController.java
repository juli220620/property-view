package com.github.juli220620.controller;

import com.github.juli220620.controller.rq.AddHotelRq;
import com.github.juli220620.model.dto.PropertyMainInfoDto;
import com.github.juli220620.service.PropertyManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.github.juli220620.Application.ROOT;

@RestController
@RequiredArgsConstructor
@RequestMapping(ROOT + "/hotels")
public class PropertyManagementController {

    private final PropertyManagementService propertyManagementService;

    @PostMapping
    public PropertyMainInfoDto addHotel(@RequestBody AddHotelRq rq) {
        return propertyManagementService.addHotel(rq);
    }

    @PostMapping("/{hotel_id}/amenities")
    public void addAmenities(@PathVariable Long hotel_id,
                             @RequestBody List<String> amenities) {
        propertyManagementService.addAmenities(hotel_id, amenities);
    }
}
