package pl.maczi.springboottest.shop;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Plus")
public class PlusShop {


    ProductService productService;

    public PlusShop(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {

        double fiveRandomProducts = productService.getFiveRandomProducts();
        System.out.println(
                fiveRandomProducts
        );
    }
}
