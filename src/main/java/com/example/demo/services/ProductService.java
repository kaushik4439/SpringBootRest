package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    private Map<Integer, Product> productMap = new HashMap<>();

    public Product getProductDetails(int productId)
    {
        Optional<Product> product = productRepo.findById(productId);
        return product.orElse(null);
    }

    public Product createProduct(Product product)
    {
        if(product != null)
        {
            return productRepo.save(product);

        }
        return null;
    }

    public List<Product> getAllProducts()
    {
        return productRepo.findAll();
    }

    public Product updateProduct(Product product)
    {
        if(productRepo.findById(product.getProductId()).isPresent())
        {
            return productRepo.save(product);
        }
        return null;
    }

    public boolean deleteProduct(int productId)
    {
        if(productRepo.findById(productId).isPresent())
        {
            productRepo.deleteById(productId);
            return true;
        }
        return false;
    }

}
/*
price
itemName
itemTye
*/