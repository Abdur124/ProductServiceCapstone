package com.scaler.productservicecapstone.services;

import com.scaler.productservicecapstone.exceptions.ProductNotFoundException;
import com.scaler.productservicecapstone.models.Category;
import com.scaler.productservicecapstone.models.Product;
import com.scaler.productservicecapstone.repository.CategoryRepository;
import com.scaler.productservicecapstone.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productDbService")
public class ProductDBService implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
       // return productRepository.findAll();

        Optional<Category> categoryOptional = categoryRepository.findByName("Electronics");

        //List<Product> products = productRepository.findByCategory(categoryOptional.get());

        List<Product> products = categoryOptional.get().getProducts();

        return products;
    }

    @Override
    public Product createProduct(String title, String description, double price, String image, String category) {
        Product product = new Product();
        product.setName(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        Category categoryObj = getCategoryFromDb(category);
        product.setCategory(categoryObj);
        return productRepository.save(product);
    }

    private Category getCategoryFromDb(String name) {

        Optional<Category> category = categoryRepository.findByName(name);

        if (category.isPresent()) {
            return category.get();
        }

        Category categoryObj = new Category();
        categoryObj.setName(name);
        return categoryRepository.save(categoryObj);
    }
}
