package com.github.juli220620.controller;

import com.github.juli220620.dao.PropertyRepo;
import com.github.juli220620.mapper.PropertyMapper;
import com.github.juli220620.model.PropertyEntity;
import com.github.juli220620.model.dto.PropertyMainInfoDto;
import com.github.juli220620.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/property-view")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;
    private final PropertyRepo propertyRepo;
    private final PropertyMapper propertyMapper;


    @PostMapping
    public void add() {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setName("Hotel1");


    }

    @GetMapping
    public PropertyMainInfoDto get() {
        return propertyMapper.toMainInfoDto(propertyRepo.findById(1L).orElse(null));
    }

    @GetMapping("/search")
    public List<PropertyMainInfoDto> getAllBy(@RequestParam(required = false) List<String> name,
                                              @RequestParam(required = false) List<String> brand,
                                              @RequestParam(required = false) List<String> city,
                                              @RequestParam(required = false) List<String> country,
                                              @RequestParam(required = false) List<String> amenities
    ) {
        return propertyService.findAllByParams(name, brand, city, country, amenities);
    }

    @GetMapping("/all")
    public List<PropertyMainInfoDto> getAll() {
        return propertyRepo.findAll().stream().map(propertyMapper::toMainInfoDto).collect(Collectors.toList());
    }
}
