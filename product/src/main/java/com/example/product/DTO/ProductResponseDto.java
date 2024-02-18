package com.example.product.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String title;
    private Long price;
    private String description;
    private String image;
    private String category;
}
