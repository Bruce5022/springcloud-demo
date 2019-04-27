package com.sky.product.service;


import com.sky.product.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProduct();

    Product findById(Integer id);
}
