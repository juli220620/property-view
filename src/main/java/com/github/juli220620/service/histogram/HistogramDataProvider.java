package com.github.juli220620.service.histogram;

import com.github.juli220620.service.PropertyParamKey;

import java.util.List;

public interface HistogramDataProvider {

    List<Object[]> provide();

    PropertyParamKey key();

}
