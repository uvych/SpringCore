package com.gb.vtb.springcore.controllers;

import com.gb.vtb.springcore.model.Product;
import com.gb.vtb.springcore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllActions(){
        return "action_product";
    }

    @GetMapping("/all")
    public String getAllProduct(Model model){
        model.addAttribute("frontProduct", productService.getAllProduct());
        return "all_product";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/product/all";
    }

    @GetMapping("/form")
    public String getAddForm(){
        return "add_product_form";
    }

    @GetMapping("/id_form")
    public String getIdForm(){
        return "find_by_id_form";
    }

    @GetMapping("find/")
    public String getProductById(@RequestParam Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product_by_id";
    }
}
