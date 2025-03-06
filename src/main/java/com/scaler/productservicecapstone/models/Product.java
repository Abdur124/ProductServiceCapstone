package com.scaler.productservicecapstone.models;

import com.scaler.productservicecapstone.dto.ProductResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;

}
