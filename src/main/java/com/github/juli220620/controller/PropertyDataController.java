package com.github.juli220620.controller;

import com.github.juli220620.model.dto.PropertyDto;
import com.github.juli220620.model.dto.PropertyMainInfoDto;
import com.github.juli220620.service.PropertyDataService;
import jakarta.servlet.http.HttpServletRequest;
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
    public List<PropertyMainInfoDto> getAllBy(HttpServletRequest request) {
        return propertyDataService.findAllByParams(request.getParameterMap());
    }

    @GetMapping("/hotels")
    public List<PropertyMainInfoDto> getAll() {
        return propertyDataService.getAll();
    }
}
