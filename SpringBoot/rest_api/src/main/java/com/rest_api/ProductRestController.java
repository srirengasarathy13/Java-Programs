package com.rest_api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
public class ProductRestController {
    @GetMapping("/api/product")
    public Product getProduct() {
        return new Product(101, "SUMSUNG S24 Ultra", "Mobile Phone", 140000, 25);
    }
    
}
