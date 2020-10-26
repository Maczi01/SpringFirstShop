package pl.maczi.springboottest.shop;

import java.util.Random;

public class Product {

    private double price;
    private String name;
    private Random random = new Random();

    public Product(String name) {
        this.name = name;
        this.price = random.nextInt(50) * 6;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Price:" + price;
    }
}
