package com.example.exam_ead.controller;

import com.example.exam_ead.entities.ProductEntity;
import com.example.exam_ead.entities.SaleEntity;
import com.example.exam_ead.service.ProductService;
import com.example.exam_ead.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService service;
@Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String getAll(ModelMap modelMap){
        try{
            List<SaleEntity> saleList = service.getAll();
            modelMap.addAttribute("saleList",saleList);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "sale";
    }

    @GetMapping("/add-sale")
    public String addProduct(ModelMap modelMap){
        try{
            List<ProductEntity> productList = productService.getAll();
            modelMap.addAttribute("productList",productList);
            SaleEntity sale = new SaleEntity();
            modelMap.addAttribute("sale",sale);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "createSale";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("sale") SaleEntity sale) {
        try {
            service.createSale(sale);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "redirect:/sale/list";
    }
}
