package com.scaler.productservicecapstone.services;

import com.scaler.productservicecapstone.dto.ProductResponseDto;
import com.scaler.productservicecapstone.models.Product;
import jdk.jfr.RecordingState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
}
