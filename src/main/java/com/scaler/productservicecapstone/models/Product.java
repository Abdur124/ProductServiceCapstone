package com.scaler.productservicecapstone.models;

import com.scaler.productservicecapstone.dto.ProductResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String description;
    private double price;
    private String imageUrl;
    @ManyToOne
    private Category category;

}
