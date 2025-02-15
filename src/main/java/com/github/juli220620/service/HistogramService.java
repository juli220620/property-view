package com.github.juli220620.service;

import com.github.juli220620.service.histogram.HistogramDataProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HistogramService {
    private final Map<String, HistogramDataProvider> dataProviders;

    public HistogramService(Set<HistogramDataProvider> dataProviders) {
        this.dataProviders = dataProviders.stream()
                .collect(Collectors.toMap(
                        histogramDataProvider -> histogramDataProvider.key().getValue(),
                        histogramDataProvider -> histogramDataProvider));
    }

    public Map<String, Integer> statistics(String key) {
        var dataProvider = Optional.ofNullable(dataProviders.get(key))
                .orElseThrow(() -> new IllegalArgumentException("Unknown statistics key: " + key));
        var data = dataProvider.provide();
        return transform(data);
    }

    private Map<String, Integer> transform(List<Object[]> data) {
        return data.stream().collect(Collectors.toMap(
                pair -> pair[0].toString(),
                pair -> Integer.parseInt(pair[1].toString())
        ));
    }
}
