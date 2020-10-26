package pl.maczi.springboottest.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Value("${shop.tax}")
    private double tax;
    @Value("${shop.discount}")
    private double discount;
    private final double SUM_QUALIFYING_TO_DISCOUNT = 500;
    private String[] tableWithNames = {"Eggs", "Oats", "Tomatoes", "Bread", "Water"};

    public ProductService() {
    }

    public double getPriceForFiveRandomProducts() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            productList.add(new Product(tableWithNames[i]));
        }

        double sum = productList
                .stream()
                .map(Product::getPrice)
                .map(e -> e + (e * tax))
                .mapToDouble(a -> a)
                .sum();

        if (sum > SUM_QUALIFYING_TO_DISCOUNT) {
            sum = sum - (sum * discount);
        }
        return sum;
    }

}
