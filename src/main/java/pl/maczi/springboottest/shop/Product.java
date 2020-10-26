package pl.maczi.springboottest.shop;

import java.util.Random;

public class Product {

    private double price;
    private Random random = new Random();

    public Product() {
        this.price = random.nextInt(50) * 6;
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
