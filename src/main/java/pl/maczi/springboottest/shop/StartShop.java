package pl.maczi.springboottest.shop;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

@Profile("Start")
public class StartShop {

    ProductService productService;

    public StartShop(ProductService productService) {
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
