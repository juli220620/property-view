package com.github.juli220620.mapper;

import com.github.juli220620.model.PropertyContactEntity;
import com.github.juli220620.model.dto.PropertyContactDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ContactMapper {

    @Mapping(target = "hotel", ignore = true)
    PropertyContactEntity fromDto(PropertyContactDto dto);

    PropertyContactDto toDto(PropertyContactEntity propertyContactEntity);
}
