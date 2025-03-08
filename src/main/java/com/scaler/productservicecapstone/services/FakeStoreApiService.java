package com.scaler.productservicecapstone.services;

import com.scaler.productservicecapstone.dto.ProductRequestDto;
import com.scaler.productservicecapstone.dto.ProductResponseDto;
import com.scaler.productservicecapstone.models.Product;
import jdk.jfr.RecordingState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

@Service
public class FakeStoreApiService implements ProductService {

    private static final String fakeStoreUrl = "https://fakestoreapi.com/products/";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product getProductById(long id) {

        ProductResponseDto productResponseDto = restTemplate.getForObject(fakeStoreUrl + id, ProductResponseDto.class);
        return (productResponseDto!= null) ? productResponseDto.toProduct(productResponseDto) : null;
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();
       ProductResponseDto[] fakeStoreProducts = restTemplate.getForObject(fakeStoreUrl, ProductResponseDto[].class);

        for (ProductResponseDto productResponseDto : fakeStoreProducts) {
           products.add(productResponseDto.toProduct(productResponseDto));
       }

       return products;
    }

    @Override
    public Product createProduct(String title, String description, double price, String image, String category) {

        ProductRequestDto requestDto = new ProductRequestDto();
        requestDto.setTitle(title);
        requestDto.setDescription(description);
        requestDto.setPrice(price);
        requestDto.setImage(image);
        requestDto.setCategory(category);
        ProductResponseDto productResponseDto = restTemplate.postForObject(fakeStoreUrl, requestDto, ProductResponseDto.class);
        return productResponseDto.toProduct(productResponseDto);
    }


}
