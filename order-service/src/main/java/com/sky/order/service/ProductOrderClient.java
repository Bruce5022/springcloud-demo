package com.sky.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("product-service")
public interface ProductOrderClient {

    @RequestMapping("/api/product/find")
    String findById(@RequestParam("id") Integer productId);
}
