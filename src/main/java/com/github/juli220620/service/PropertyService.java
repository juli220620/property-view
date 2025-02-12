package com.github.juli220620.service;

import com.github.juli220620.dao.PropertyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepo propertyRepo;
}
