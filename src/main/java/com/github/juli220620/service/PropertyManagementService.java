package com.github.juli220620.service;

import com.github.juli220620.controller.rq.AddHotelRq;
import com.github.juli220620.dao.PropertyRepo;
import com.github.juli220620.mapper.PropertyMapper;
import com.github.juli220620.model.dto.PropertyMainInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class PropertyManagementService {

    private final PropertyRepo propertyRepo;
    private final PropertyMapper propertyMapper;

    public PropertyMainInfoDto addHotel(AddHotelRq rq) {
        var baseInfo = PropertyMapper.setBaseInfo(rq);
        propertyRepo.save(baseInfo);

        var fullInfo = propertyMapper.baseInfoToEntity(rq);
        fullInfo.setId(baseInfo.getId());
        fullInfo.getAddress().setHotelId(baseInfo.getId());
        fullInfo.getArrivalTime().setHotelId(baseInfo.getId());
        fullInfo.getContact().setHotelId(baseInfo.getId());

        try {
            propertyRepo.save(fullInfo);
        } catch (TransactionSystemException e) {
            propertyRepo.delete(fullInfo);
            throw e;
        }

        return propertyMapper.toMainInfoDto(fullInfo);
    }

    public void addAmenities(Long hotelId, List<String> amenities) {
        var entity = propertyRepo.findById(hotelId)
                .orElseThrow(() -> new NoSuchElementException("No such hotel"));

        var amenityEntities = PropertyMapper.stringToAmenities(amenities);
        entity.getAmenities().clear();
        entity.getAmenities().addAll(amenityEntities);
        propertyRepo.save(entity);
    }
}
