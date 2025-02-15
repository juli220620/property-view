package com.github.juli220620.mapper;

import com.github.juli220620.model.PropertyArrivalTimeEntity;
import com.github.juli220620.model.dto.PropertyArrivalTimeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ArrivalTimeMapper {

    @Mapping(target = "hotel", ignore = true)
    PropertyArrivalTimeEntity fromDto(PropertyArrivalTimeDto dto);

    PropertyArrivalTimeDto toDto(PropertyArrivalTimeEntity propertyArrivalTimeEntity);
}
