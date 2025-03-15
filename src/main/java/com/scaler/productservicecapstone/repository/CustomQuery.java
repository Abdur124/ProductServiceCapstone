package com.scaler.productservicecapstone.repository;

public class CustomQuery {

    public static final String GET_PRODUCTS_BY_CATEGORY_NAME = "select * from product where category_id in (select category_id from category where name=:categoryName)";
}
