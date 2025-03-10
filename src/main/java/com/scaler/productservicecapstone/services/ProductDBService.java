package com.scaler.productservicecapstone.services;

import com.scaler.productservicecapstone.exceptions.ProductNotFoundException;
import com.scaler.productservicecapstone.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productDbService")
public class ProductDBService implements ProductService{

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String title, String description, double price, String image, String category) {
        return null;
    }
}
