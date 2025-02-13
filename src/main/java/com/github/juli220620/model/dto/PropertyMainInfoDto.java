package com.github.juli220620.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyMainInfoDto {

    private Long id;
    private String name;
    private String description;
    private String address;
    private String phone;

}
