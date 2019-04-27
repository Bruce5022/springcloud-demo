package com.sky.order.service;

import com.sky.order.entity.Order;

public interface OrderService {

    Order save(Integer userId, Integer productId);
}
