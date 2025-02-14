package com.github.juli220620.service.histogram;

import java.util.List;

public interface HistogramDataProvider {

    List<Object[]> provide();

    String key();

}
