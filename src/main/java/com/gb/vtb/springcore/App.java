package com.gb.vtb.springcore;


import com.gb.vtb.springcore.config.Config;
import com.gb.vtb.springcore.config.PrepareDataApp;
import com.gb.vtb.springcore.service.ProductService;
import com.gb.vtb.springcore.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = context.getBean("userService", UserService.class);
        ProductService productService = context.getBean("productService", ProductService.class);

        System.out.println(userService.getAllUsers());
        System.out.println(productService.getAllProduct());
    }
}
