package pl.maczi.springboottest.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Premium")
public class PremiumShop implements Shop {

    private ProductService productService;

    @Autowired
    public PremiumShop(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void sumPriceForFiveRandomProducts() {
        System.out.println(productService.getPriceForFiveRandomProducts());
    }
}
