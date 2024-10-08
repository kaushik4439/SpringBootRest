package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProduct/{productId}")
    public Product getProduct(@PathVariable int productId)
    {
        return productService.getProductDetails(productId);

    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        List<Product> response = productService.getAllProducts();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product)
    {
        return productService.createProduct(product);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product)
    {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public boolean deleteProduct(@PathVariable int productId)
    {
        return productService.deleteProduct(productId);

    }
}
