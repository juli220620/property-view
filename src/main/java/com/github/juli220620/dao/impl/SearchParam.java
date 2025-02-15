package com.github.juli220620.dao.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SearchParam {
    private String name;
    private List<String> values;
}
