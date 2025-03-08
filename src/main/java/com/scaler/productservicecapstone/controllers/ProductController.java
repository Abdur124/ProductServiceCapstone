package com.scaler.productservicecapstone.controllers;


import com.scaler.productservicecapstone.ProductServiceCapstoneApplication;
import com.scaler.productservicecapstone.dto.ProductRequestDto;
import com.scaler.productservicecapstone.dto.ProductResponseDto;
import com.scaler.productservicecapstone.models.Product;
import com.scaler.productservicecapstone.services.FakeStoreApiService;
import com.scaler.productservicecapstone.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private FakeStoreApiService fakeStoreApiService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable long id) {

        Product product = fakeStoreApiService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ProductResponseDto.fromProduct(product));
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() {

        List<Product> products = fakeStoreApiService.getAllProducts();

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        products.forEach(product -> productResponseDtos.add(ProductResponseDto.fromProduct(product)));

        return productResponseDtos;
    }

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
            Product product = fakeStoreApiService.createProduct(productRequestDto.getTitle(), productRequestDto.getDescription(), productRequestDto.getPrice(),
                    productRequestDto.getImage(), productRequestDto.getCategory());
            return ProductResponseDto.fromProduct(product);
    }
}
