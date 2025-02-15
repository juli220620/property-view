package com.github.juli220620.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Amenity {

    PARKING("Free parking"),
    WIFI("Free WiFi"),
    NON_SMOKING("Non-smoking rooms"),
    CONCIERGE("Concierge"),
    RESTAURANT("On-site restaurant"),
    FITNESS("Fitness center"),
    PETS("Pet-friendly rooms"),
    ROOM_SERVICE("Room service"),
    BUSINESS_CENTER("Business center"),
    MEETING_ROOMS("Meeting rooms");

    private final String beautifulName;
}
