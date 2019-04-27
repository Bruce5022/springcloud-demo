package com.sky.product.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer stockQty;

    public Product() {
    }

    public Product(Integer id, String name, BigDecimal price, Integer stockQty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQty = stockQty;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQty=" + stockQty +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQty() {
        return stockQty;
    }

    public void setStockQty(Integer stockQty) {
        this.stockQty = stockQty;
    }
}
