package com.example.product.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String name;
    private String description;
    private Long price;
    private String image;
    @ManyToOne(cascade = {CascadeType.PERSIST})
//    //PERSIST means saving, creating something new
    private Category category;

}
