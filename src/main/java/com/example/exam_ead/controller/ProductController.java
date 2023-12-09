package com.example.exam_ead.controller;

import com.example.exam_ead.entities.ProductEntity;
import com.example.exam_ead.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/list")
    public String getAll(ModelMap modelMap){
        try{
            List<ProductEntity> productList = service.getAll();
            modelMap.addAttribute("productList",productList);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "product";
    }

    @GetMapping("/add-product")
    public String addProduct(ModelMap modelMap){
        try{
            ProductEntity product = new ProductEntity();
            modelMap.addAttribute("product",product);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "createProduct";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") ProductEntity product) {
        try {
            service.createProduct(product);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "redirect:/product/list";
    }
}
