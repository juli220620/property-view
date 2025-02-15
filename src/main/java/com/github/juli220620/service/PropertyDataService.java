package com.github.juli220620.service;

import com.github.juli220620.dao.PropertyRepo;
import com.github.juli220620.dao.impl.SearchParam;
import com.github.juli220620.mapper.PropertyMapper;
import com.github.juli220620.model.PropertyEntity;
import com.github.juli220620.model.dto.PropertyDto;
import com.github.juli220620.model.dto.PropertyMainInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyDataService {

    private final PropertyMapper propertyMapper;
    private final PropertyRepo propertyRepo;


    public List<PropertyMainInfoDto> getAll() {
        return mapListToMainInfo(propertyRepo.findAll());
    }

    public PropertyDto getById(Long id) {
        return propertyRepo.findById(id)
                .map(propertyMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("No such hotel"));
    }

    public List<PropertyMainInfoDto> findAllByParams(List<String> name,
                                                     List<String> brand,
                                                     List<String> city,
                                                     List<String> country,
                                                     List<String> amenities
    ) {
        var paramList = new ArrayList<SearchParam>();

        if (name != null && !name.isEmpty()) paramList.add(new SearchParam("name", name));
        if (brand != null && !brand.isEmpty()) paramList.add(new SearchParam("brand", brand));
        if (city != null && !city.isEmpty()) paramList.add(new SearchParam("city", city));
        if (country != null && !country.isEmpty()) paramList.add(new SearchParam("country", country));
        if (amenities != null && !amenities.isEmpty()) paramList.add(new SearchParam("amenities", amenities));

        if (paramList.isEmpty()) return getAll();

        var data = propertyRepo.findAllByParams(paramList);
        return mapListToMainInfo(data);
    }

    private List<PropertyMainInfoDto> mapListToMainInfo(List<PropertyEntity> entities) {
        return entities.stream()
                .map(propertyMapper::toMainInfoDto)
                .collect(Collectors.toList());
    }
}
