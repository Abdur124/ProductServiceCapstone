package com.scaler.productservicecapstone.repository;

import com.scaler.productservicecapstone.models.Category;
import com.scaler.productservicecapstone.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByCategory(Category category);

    List<Product> findByCategory_Name(String name);

    // HQL -> Works on Java classes directly instead of Tables
    @Query("select p from Product p where p.category.name=:categoryName")
    List<Product> getProductsByCategoryName(@Param("categoryName") String categoryName);

    // Native Queries
    @Query(value = CustomQuery.GET_PRODUCTS_BY_CATEGORY_NAME, nativeQuery = true)
    List<Product> getProductsByCategoryNameNative(@Param("categoryName") String categoryName);

    public Page<Product> findByNameContaining(String query, Pageable pageable);

}
