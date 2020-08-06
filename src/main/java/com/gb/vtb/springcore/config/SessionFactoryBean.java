package com.gb.vtb.springcore.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SessionFactoryBean {

    private SessionFactory factory;

    @PostConstruct
    public void init() {
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public Session getSession(){
        return factory.getCurrentSession();
    }
}
