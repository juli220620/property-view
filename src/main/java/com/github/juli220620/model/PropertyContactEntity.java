package com.github.juli220620.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contact")
public class PropertyContactEntity {

    @NotBlank
    private String phone;

    @Email
    @NotBlank
    private String email;

    @Id
    @OneToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private PropertyEntity hotel;
}
