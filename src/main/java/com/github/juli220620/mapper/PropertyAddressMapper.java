package com.github.juli220620.mapper;

import com.github.juli220620.model.PropertyAddressEntity;
import com.github.juli220620.model.dto.PropertyAddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PropertyAddressMapper {

    @Mapping(target = "hotelId", ignore = true)
    PropertyAddressEntity dtoToEntity(PropertyAddressDto dto);

    PropertyAddressDto entityToDto(PropertyAddressEntity entity);
}
