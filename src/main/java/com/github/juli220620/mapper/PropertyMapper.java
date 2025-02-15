package com.github.juli220620.mapper;

import com.github.juli220620.controller.rq.AddHotelRq;
import com.github.juli220620.model.*;
import com.github.juli220620.model.dto.PropertyContactDto;
import com.github.juli220620.model.dto.PropertyDto;
import com.github.juli220620.model.dto.PropertyMainInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {PropertyAddressMapper.class})
public interface PropertyMapper {

    @Mapping(target = "amenities", source = "amenities", qualifiedByName = "amenitiesToString")
    PropertyDto toDto(PropertyEntity property);

    @Mapping(target = "phone", source = "property.contact.phone")
    @Mapping(target = "address", source = "address", qualifiedByName = "addressToString")
    PropertyMainInfoDto toMainInfoDto(PropertyEntity property);

    @Mapping(target = "amenities", ignore = true)
    @Mapping(target = "contact", source = "contacts", qualifiedByName = "dtoToContact")
    @Mapping(target = "id", ignore = true)
    PropertyEntity baseInfoToEntity(AddHotelRq rq);

    @Named("dtoToContact")
    @Mapping(target = "hotelId", ignore = true)
    PropertyContactEntity dtoToContact(PropertyContactDto dto);

    @Named("amenitiesToString")
    static List<String> amenitiesToString(List<AmenityEntity> amenities) {
        return amenities.stream()
                .map(AmenityEntity::getName)
                .collect(Collectors.toList());
    }

    @Named("stringToAmenities")
    static List<AmenityEntity> stringToAmenities(List<String> amenities) {
        var amenityNames = Arrays.stream(Amenity.values()).map(Amenity::getBeautifulName).toList();
        return amenities.stream().map(it -> {
            if (!amenityNames.contains(it))
                throw new IllegalArgumentException("No such amenity");
            return new AmenityEntity(Arrays.stream(Amenity.values())
                    .filter(am -> am.getBeautifulName().equals(it))
                    .findFirst()
                    .map(Enum::name)
                    .orElseThrow(), it);
        }).toList();
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

    static PropertyEntity setBaseInfo(AddHotelRq rq) {
        var baseInfo = new PropertyEntity();
        baseInfo.setName(rq.name());
        baseInfo.setBrand(rq.brand());
        baseInfo.setDescription(rq.description());
        return baseInfo;
    }
}
