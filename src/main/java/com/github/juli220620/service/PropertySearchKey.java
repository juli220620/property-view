package com.github.juli220620.service;

import com.github.juli220620.model.PropertyAddressEntity;
import com.github.juli220620.model.PropertyEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PropertySearchKey {

    BRAND(PropertyEntity.Fields.brand),
    CITY(PropertyAddressEntity.Fields.city),
    COUNTRY(PropertyAddressEntity.Fields.country),
    NAME(PropertyEntity.Fields.name),
    AMENITY(PropertyEntity.Fields.amenities);

    private final String value;
}
