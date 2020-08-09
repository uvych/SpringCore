package com.gb.vtb.springcore.service;

import com.gb.vtb.springcore.model.Product;
import com.gb.vtb.springcore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

        ProductRepository productRepository;

        @Autowired
        public void setProductRepository(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

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
