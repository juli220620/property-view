package com.github.juli220620.service;

import com.github.juli220620.dao.PropertyRepo;
import com.github.juli220620.dao.impl.SearchParam;
import com.github.juli220620.mapper.PropertyMapper;
import com.github.juli220620.model.PropertyEntity;
import com.github.juli220620.model.dto.PropertyDto;
import com.github.juli220620.model.dto.PropertyMainInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
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

    public List<PropertyMainInfoDto> findAllByParams(Map<String, String[]> params) {
        var paramList = params.entrySet().stream()
                .map(entry -> new SearchParam(entry.getKey(), parseParamValue(entry)))
                .toList();

        if (paramList.isEmpty()) return getAll();

        var data = propertyRepo.findAllByParams(paramList);
        return mapListToMainInfo(data);
    }

    private static List<String> parseParamValue(Map.Entry<String, String[]> entry) {
        return Arrays.stream(entry.getValue())
                .flatMap(it -> Arrays.stream(it.split(",")))
                .toList();
    }

    private List<PropertyMainInfoDto> mapListToMainInfo(List<PropertyEntity> entities) {
        return entities.stream()
                .map(propertyMapper::toMainInfoDto)
                .collect(Collectors.toList());
    }
}
