package pl.maczi.springboottest.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartShop implements Shop {

    ProductService productService;

    @Autowired
    public StartShop(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void sumPriceForFiveRandomProducts() {
        System.out.println(productService.getPriceForFiveRandomProducts());
    }
}
