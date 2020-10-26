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
        Product product1 = new Product("Eggs", 100);
//        Product product2 = new Product("Milk", 60);
//        Product product3 = new Product("Bread", 70);
//        Product product4 = new Product("Chocolate", 80);
//        Product product5 = new Product("Oats", 300);
//        Product product6 = new Product("Water", 250);
//        Product product7 = new Product("Tomato", 200);
//        Product product8 = new Product("Mushroom", 150);
        productList.add(product1);
        productList.add(product1);
        productList.add(product1);
        productList.add(product1);
        productList.add(product1);
//        productList.add(product6);
//        productList.add(product7);
//        productList.add(product8);
//        Set<Product> productSet = new HashSet<>();
//        Random random = new Random();
//        while (productSet.size() < 5) {
//            productSet.add(
//                    productList.get(random.nextInt(5)));
//        }
//        List<Product> listOfFive = new ArrayList<>(productSet);
        List<Integer> toSum = new ArrayList<>();

        for (Product product : productList) {
            toSum.add((int) (product.getPrice() / tax));
        }
        return toSum.stream().mapToInt(a -> a).sum();


//        return listOfFive;
    }

//    public double calculateSum(List<Product> list) {
//        List<Integer> toSum = new ArrayList<>();
//        for (Product product : list) {
//            toSum.add((int) (product.getPrice() + (product.getPrice() * tax)));
//        }
//        return toSum.stream().mapToInt(a -> a).sum();
//
//    }

}
