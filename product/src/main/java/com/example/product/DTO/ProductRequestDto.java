package com.example.product.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String title;
    private Long price;
    private String description;
    private String image;
    private String category;
}
