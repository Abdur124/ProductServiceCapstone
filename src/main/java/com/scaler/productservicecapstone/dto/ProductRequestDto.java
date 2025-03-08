package com.scaler.productservicecapstone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {

    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
