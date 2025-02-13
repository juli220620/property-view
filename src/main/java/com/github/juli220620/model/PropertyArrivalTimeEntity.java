package com.github.juli220620.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "arrival_time")
public class PropertyArrivalTimeEntity {

    @Id
    private Long hotelId;

    private String checkIn;
    private String checkOut;

}
