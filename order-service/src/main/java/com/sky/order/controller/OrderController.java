package com.sky.order.controller;

import com.sky.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("save")
    public Object save(@RequestParam("user_id") Integer userId, @RequestParam("product_id") Integer productId) {
        return orderService.save(userId, productId);
    }
}
