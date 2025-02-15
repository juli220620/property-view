package com.github.juli220620.mapper;

import com.github.juli220620.controller.rq.AddHotelRq;
import com.github.juli220620.model.PropertyAddressEntity;
import com.github.juli220620.model.PropertyEntity;
import com.github.juli220620.model.dto.PropertyDto;
import com.github.juli220620.model.dto.PropertyMainInfoDto;
import org.mapstruct.*;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {AddressMapper.class, AmenityMapper.class, ContactMapper.class, ArrivalTimeMapper.class})
public interface PropertyMapper {

    PropertyDto toDto(PropertyEntity property);

    @Mapping(target = "contact", source = "contacts")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "amenities", ignore = true)
    PropertyEntity fromDto(AddHotelRq addHotelRq);

    @AfterMapping
    default void setBiDirectional(@MappingTarget PropertyEntity property) {
        property.getAddress().setHotel(property);
        property.getContact().setHotel(property);
        property.getArrivalTime().setHotel(property);
    }

    @Mapping(target = "phone", source = "property.contact.phone")
    @Mapping(target = "address", source = "address", qualifiedByName = "addressToString")
    PropertyMainInfoDto toMainInfoDto(PropertyEntity property);


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
