package com.gb.vtb.springcore.repository;

import com.gb.vtb.springcore.config.SessionFactoryBean;
import com.gb.vtb.springcore.model.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepository {
    @Autowired
    private SessionFactoryBean factory;


    public void save(Product product){
        Session session = factory.getSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }

    public Product findById(Long id){
        Session session = factory.getSession();
        session.beginTransaction();
        Product product = session.find(Product.class, id);
        session.getTransaction().commit();
        session.close();
        return product;
    }

    public List<Product> findAll(){
        Session session = factory.getSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product", Product.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return products;
    }
}
