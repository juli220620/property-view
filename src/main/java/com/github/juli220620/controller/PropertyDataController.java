package com.github.juli220620.controller;

import com.github.juli220620.model.dto.PropertyDto;
import com.github.juli220620.model.dto.PropertyMainInfoDto;
import com.github.juli220620.service.PropertyDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.github.juli220620.Application.ROOT;

@RestController
@RequestMapping(ROOT)
@RequiredArgsConstructor
public class PropertyDataController {

    private final PropertyDataService propertyDataService;

    @GetMapping("/hotels/{id}")
    public PropertyDto get(@PathVariable Long id) {
        return propertyDataService.getById(id);
    }

    @GetMapping("/search")
    public List<PropertyMainInfoDto> getAllBy(@RequestParam(required = false) List<String> name,
                                              @RequestParam(required = false) List<String> brand,
                                              @RequestParam(required = false) List<String> city,
                                              @RequestParam(required = false) List<String> country,
                                              @RequestParam(required = false) List<String> amenities
    ) {
        return propertyDataService.findAllByParams(name, brand, city, country, amenities);
    }

    @GetMapping("/hotels")
    public List<PropertyMainInfoDto> getAll() {
        return propertyDataService.getAll();
    }
}
