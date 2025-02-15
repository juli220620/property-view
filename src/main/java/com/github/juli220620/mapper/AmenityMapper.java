package com.github.juli220620.mapper;

import com.github.juli220620.model.AmenityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AmenityMapper {

    @Mapping(target = "name", source = "amenity")
    AmenityEntity fromDto(String amenity);


    default List<String> amenitiesToString(List<AmenityEntity> amenity) {
        return amenity.stream().map(AmenityEntity::getName).collect(Collectors.toList());
    }
}
