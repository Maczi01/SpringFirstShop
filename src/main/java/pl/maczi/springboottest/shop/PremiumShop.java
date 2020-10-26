package pl.maczi.springboottest.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("Premium")
public class PremiumShop {

    private ProductService productService;

    @Autowired
    public PremiumShop(ProductService productService) {
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
