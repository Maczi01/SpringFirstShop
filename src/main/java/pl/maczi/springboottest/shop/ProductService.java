package pl.maczi.springboottest.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Value("${shop.tax}")
    private double tax;
    @Value("${shop.discount}")
    private double discount;
    private final double SUM_QUALIFYING_TO_DISCOUNT = 500;

    public ProductService() {

    }

    public double getFiveRandomProducts() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            productList.add(new Product());
        }

        List<Integer> toSum = new ArrayList<>();

        double sum = productList.stream().map(e -> e.getPrice()).mapToDouble(a -> a).sum();
        if (sum > SUM_QUALIFYING_TO_DISCOUNT) {
            sum = sum - (sum * discount);
        }
        return sum;
    }

}
