package com.github.juli220620.controller;

import com.github.juli220620.service.HistogramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.github.juli220620.Application.ROOT;

@RestController
@RequestMapping(ROOT)
@RequiredArgsConstructor
public class StatisticsController {

    private final HistogramService histogramService;

    @GetMapping("/histogram/{param}")
    public Map<String, Integer> histogram(@PathVariable String param) {
        return histogramService.statistics(param);
    }
}