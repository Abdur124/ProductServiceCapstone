package com.scaler.productservicecapstone.dto;

import com.scaler.productservicecapstone.models.Category;
import com.scaler.productservicecapstone.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {

    private long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public Product toProduct(ProductResponseDto productResponseDto) {
        Product product = new Product();
        product.setId(productResponseDto.getId());
        product.setName(productResponseDto.getTitle());
        product.setDescription(productResponseDto.getDescription());
        product.setPrice(productResponseDto.getPrice());
        product.setImageUrl(productResponseDto.getImage());
        Category category = new Category();
        category.setId(1);
        category.setName(productResponseDto.getCategory());
        product.setCategory(category);
        return product;
    }

    public static ProductResponseDto fromProduct(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setTitle(product.getName());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setImage(product.getImageUrl());
        productResponseDto.setCategory(product.getCategory().getName());
        return productResponseDto;
    }

}
