package com.gb.vtb.springcore.service;

import com.gb.vtb.springcore.model.Product;
import com.gb.vtb.springcore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
}
