package com.sky.order.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.order.entity.Order;
import com.sky.order.service.OrderService;
import com.sky.order.service.ProductOrderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private static Logger logger = LoggerFactory.getLogger(OrderService.class);

    private ObjectMapper om = new ObjectMapper();

    @Resource
    private ProductOrderClient productOrderClient;


    @Override
    public Order save(Integer userId, Integer productId) {

        logger.info("OrderService save");
        String resStr = productOrderClient.findById(productId);
        JsonNode jsonNode = om.createObjectNode();
        try {
            jsonNode = om.readTree(resStr);
        } catch (IOException e) {
        }

        Order order = new Order();
        order.setCreateTime(new Date());
        order.setTradeNo(UUID.randomUUID().toString());
        order.setUserId(userId);
        order.setProductName(jsonNode.get("name").toString());
        order.setPrice(new BigDecimal(jsonNode.get("price").toString()));

        return order;
    }
}
