package com.example.exam_ead.service.impl;

import com.example.exam_ead.entities.ProductEntity;
import com.example.exam_ead.repository.ProductRopesitory;
import com.example.exam_ead.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRopesitory productRopesitory;
    @Override
    public void createProduct(ProductEntity product) {
        try{
            productRopesitory.save(product);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<ProductEntity> getAll() {
        return productRopesitory.findAll();
    }
}
