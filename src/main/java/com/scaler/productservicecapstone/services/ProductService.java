package com.scaler.productservicecapstone.services;

import com.scaler.productservicecapstone.exceptions.ProductNotFoundException;
import com.scaler.productservicecapstone.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(long id) throws ProductNotFoundException;

    public List<Product> getAllProducts();

    public Product createProduct(String title, String description, double price, String image, String category);

}
