package pl.maczi.springboottest.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.maczi.springboottest.shop.service.ProductService;

@Component
public class StartShopInterfaceController implements ShopInterface {

    ProductService productService;

    @Autowired
    public StartShopInterfaceController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void sumPriceForFiveRandomProducts() {
        System.out.println(productService.getPriceForFiveRandomProducts());
    }
}
