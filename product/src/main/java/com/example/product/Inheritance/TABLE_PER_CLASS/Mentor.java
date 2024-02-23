package com.example.product.Inheritance.TABLE_PER_CLASS;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TPC_Mentor")
public class Mentor extends User {
    private Double avgRating;
    private String Company;

}
