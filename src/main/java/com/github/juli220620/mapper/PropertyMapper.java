package com.github.juli220620.mapper;

import com.github.juli220620.model.AmenityEntity;
import com.github.juli220620.model.PropertyAddressEntity;
import com.github.juli220620.model.PropertyEntity;
import com.github.juli220620.model.dto.PropertyDto;
import com.github.juli220620.model.dto.PropertyMainInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PropertyMapper {

    @Mapping(target = "amenities", source = "amenities", qualifiedByName = "amenitiesToString")
    PropertyDto toDto(PropertyEntity property);

    @Mapping(target = "phone", source = "property.contact.phone")
    @Mapping(target = "address", source = "address", qualifiedByName = "addressToString")
    PropertyMainInfoDto toMainInfoDto(PropertyEntity property);

    @Named("amenitiesToString")
    static List<String> amenitiesToString(List<AmenityEntity> amenities) {
        return amenities.stream().map(AmenityEntity::getName).collect(Collectors.toList());
    }

    @Named("addressToString")
    static String addressToString(PropertyAddressEntity address) {
        return String.format("%d %s, %s, %s, %s",
                address.getHouseNumber(),
                address.getStreet(),
                address.getCity(),
                address.getPostCode(),
                address.getCountry()
        );
    }
}
