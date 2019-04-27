package com.sky.product.controller;


import com.sky.product.entity.Product;
import com.sky.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Value("${server.port}")
    private String port;

    @RequestMapping("list")
    public Object list() {
        List<Product> products = productService.listProduct();
        List<Product> results = new ArrayList<>();
        for (Product product : products) {
            Product result = new Product();
            BeanUtils.copyProperties(product, result);
            result.setName(product.getName() + " data from port " + port);
            results.add(result);
        }
        return results;
    }

    @RequestMapping("find")
    public Object findById(@RequestParam("id") Integer id) {
        Product product = productService.findById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product, result);
        result.setName(product.getName() + " data from port " + port);
        return result;
    }
}
