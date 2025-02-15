package com.github.juli220620.service;

import com.github.juli220620.controller.rq.AddHotelRq;
import com.github.juli220620.dao.PropertyRepo;
import com.github.juli220620.mapper.AmenityMapper;
import com.github.juli220620.mapper.PropertyMapper;
import com.github.juli220620.model.dto.PropertyMainInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class PropertyManagementService {

    private final PropertyRepo propertyRepo;
    private final PropertyMapper propertyMapper;
    private final AmenityMapper amenityMapper;

    public PropertyMainInfoDto addHotel(AddHotelRq rq) {
        var hotel = propertyMapper.fromDto(rq);
        hotel = propertyRepo.save(hotel);
        return propertyMapper.toMainInfoDto(hotel);
    }

    public void addAmenities(Long hotelId, List<String> amenities) {
        var hotel = propertyRepo.findById(hotelId)
                .orElseThrow(() -> new NoSuchElementException("No such hotel"));

        var amenityEntities = amenities.stream().map(amenityMapper::fromDto).toList();
        hotel.getAmenities().clear();
        hotel.getAmenities().addAll(amenityEntities);
        propertyRepo.save(hotel);
    }
}
