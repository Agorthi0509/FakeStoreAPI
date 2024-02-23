package com.example.product.Inheritance.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "MSP_Mentor")
public class Mentor extends User {
    private Double avgRating;
    private String Company;

}
