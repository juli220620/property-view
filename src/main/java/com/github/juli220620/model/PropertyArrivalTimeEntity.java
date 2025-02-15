package com.github.juli220620.model;

import jakarta.persistence.*;
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
    private String checkIn;
    private String checkOut;

    @Id
    @OneToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private PropertyEntity hotel;

}
