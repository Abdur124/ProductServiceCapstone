package com.scaler.productservicecapstone.controllers;


import com.scaler.productservicecapstone.ProductServiceCapstoneApplication;
import com.scaler.productservicecapstone.dto.ProductResponseDto;
import com.scaler.productservicecapstone.models.Product;
import com.scaler.productservicecapstone.services.FakeStoreApiService;
import com.scaler.productservicecapstone.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private FakeStoreApiService fakeStoreApiService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable long id) {

        Product product = fakeStoreApiService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ProductResponseDto.fromProduct(product));
    }
}
