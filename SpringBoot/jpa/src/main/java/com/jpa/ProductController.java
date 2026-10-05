package com.jpa;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable("productId") String productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(
            @PathVariable String productId,
            @RequestBody Product updatedProduct) {

        return productService.updateProduct(productId, updatedProduct);
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable String productId) {

        if (productService.deleteProduct(productId)) {
            return "Product " + productId + " deleted successfully.";
        }

        return "Product not found.";
    }
}