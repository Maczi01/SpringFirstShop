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


    public ProductService() {

    }

    public double getFiveRandomProducts() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            productList.add(new Product());
        }

        List<Integer> toSum = new ArrayList<>();

        for (Product product : productList) {
            toSum.add((int) (product.getPrice() + (product.getPrice() * tax)));
        }



        
        double sum = toSum.stream().mapToInt(a -> a).sum();
        if (sum > 500) {
            sum = sum - (sum * discount);
        }
        return sum;
    }

}
