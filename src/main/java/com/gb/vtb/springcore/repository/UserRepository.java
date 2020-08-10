package com.gb.vtb.springcore.repository;

import com.gb.vtb.springcore.config.SessionFactoryBean;
import com.gb.vtb.springcore.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository {

    private SessionFactoryBean factory;

    @Autowired
    public void setFactory(SessionFactoryBean factory) {
        this.factory = factory;
    }

    public void save(User user){
        Session session = factory.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User findById(Long id){
        Session session = factory.getSession();
        session.beginTransaction();
        User user = session.find(User.class, id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public List<User> findAll(){
        Session session = factory.getSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User", User.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return users;
    }
}
