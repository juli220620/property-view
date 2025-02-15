package com.github.juli220620.mapper;

import com.github.juli220620.model.PropertyAddressEntity;
import com.github.juli220620.model.dto.PropertyAddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "hotel", ignore = true)
    PropertyAddressEntity dtoToEntity(PropertyAddressDto dto);

    PropertyAddressDto entityToDto(PropertyAddressEntity entity);

}
