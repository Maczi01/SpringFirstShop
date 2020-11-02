package pl.maczi.springboottest.shop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.maczi.springboottest.shop.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Value("${shop.tax}")
    private double tax;
    @Value("${shop.discount}")
    private double discount;
    private final BigDecimal SUM_QUALIFYING_TO_DISCOUNT = BigDecimal.valueOf(500);
    private String[] tableWithNames = {"Eggs", "Oats", "Tomatoes", "Bread", "Water"};

    public ProductService() {
    }

    public BigDecimal getPriceForFiveRandomProducts() {
        List<Product> productList = addRandomNamesForProducts();
        BigDecimal sum = sumAllProducts(productList);
        sum = checkDiscount(sum);
        return sum;
    }

    private List<Product> addRandomNamesForProducts() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            productList.add(new Product(tableWithNames[i]));
        }
        return productList;
    }

    private BigDecimal sumAllProducts(List<Product> productList) {
        return productList
                    .stream()
                    .map(Product::getPrice)
                    .map(e -> e.add(e.multiply(BigDecimal.valueOf(tax))))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal checkDiscount(BigDecimal sum) {
        if (sum.compareTo(SUM_QUALIFYING_TO_DISCOUNT) > 0) {
            sum = sum.subtract((sum.multiply(BigDecimal.valueOf(discount))));
        }
        return sum;
    }

}
