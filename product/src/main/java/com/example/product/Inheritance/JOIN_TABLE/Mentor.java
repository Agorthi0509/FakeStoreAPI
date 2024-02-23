package com.example.product.Inheritance.JOIN_TABLE;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_Mentor")
@PrimaryKeyJoinColumn(name ="user_id")
public class Mentor extends User {
    private Double avgRating;
    private String Company;

}
