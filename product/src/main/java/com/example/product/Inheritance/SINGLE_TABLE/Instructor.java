package com.example.product.Inheritance.SINGLE_TABLE;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ST_Instructor")
@DiscriminatorValue("2")
public class Instructor extends User {
    private Double avgRating;
    private String specialization;
}
