package com.sky.product.service.impl;

import com.sky.product.entity.Product;
import com.sky.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private static Map<Integer, Product> map = new HashMap<>();

    static {
        map.put(1, new Product(1, "苹果", new BigDecimal("12.6"), 5));
        map.put(2, new Product(2, "香蕉", new BigDecimal(10), 100));
        map.put(3, new Product(3, "西紅柿", new BigDecimal(3), 121));
        map.put(4, new Product(4, "馬鈴薯", new BigDecimal(2), 999));

    }

    @Override
    public List<Product> listProduct() {
        logger.info("ProductService listProduct");
        Collection<Product> values = map.values();
        return new ArrayList<>(values);
    }

    @Override
    public Product findById(Integer id) {
        logger.info("ProductService findById");
        return map.get(id);
    }
}
