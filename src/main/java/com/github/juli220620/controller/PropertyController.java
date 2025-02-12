package com.github.juli220620.controller;

import com.github.juli220620.model.AmenityEntity;
import com.github.juli220620.model.PropertyEntity;
import com.github.juli220620.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/property-view")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;


    @PostMapping
    public void add() {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setName("Hotel1");


    }

    @GetMapping
    public List<AmenityEntity> get() {
        return null;
    }
}
