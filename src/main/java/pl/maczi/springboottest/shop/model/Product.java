package pl.maczi.springboottest.shop.model;

import org.apache.commons.lang.math.RandomUtils;

import java.math.BigDecimal;

public class Product {

    private BigDecimal price;
    private String name;

    public Product(String name) {
        this.name = name;
        this.price = BigDecimal.valueOf(RandomUtils.nextInt(300));
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


    @Override
    public String toString() {
        return "Price:" + price;
    }
}
