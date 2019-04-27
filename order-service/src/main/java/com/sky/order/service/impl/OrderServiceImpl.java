package com.sky.order.service.impl;

import com.sky.order.entity.Order;
import com.sky.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    // 方式一:
//    @Autowired
//    private RestTemplate restTemplate;

    // 方式二:
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public Order save(Integer userId, Integer productId) {
        // 获取商品详情

        // 方式一:
//        Map map = restTemplate.getForObject("http://product-service/api/product/find?id=" + productId, Map.class);
        // 方式二:
        ServiceInstance serviceInstance = loadBalancerClient.choose("product-service");
        RestTemplate template = new RestTemplate();
        String url = String.format("http://%s:%s/api/product/find?id=" + productId, serviceInstance.getHost(), serviceInstance.getPort());
        Map map = template.getForObject(url, Map.class);


        System.out.println("=================" + map + "==================");

        Order order = new Order();
        order.setCreateTime(new Date());
        order.setTradeNo(UUID.randomUUID().toString());
        order.setUserId(userId);
        order.setProductName(map.get("name").toString());
        order.setPrice(new BigDecimal(map.get("price").toString()));

        return order;
    }
}
