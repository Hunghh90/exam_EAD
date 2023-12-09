package com.example.exam_ead.service;


import com.example.exam_ead.entities.ProductEntity;

import java.util.List;

public interface ProductService  {
    void createProduct(ProductEntity product);
    List<ProductEntity> getAll();
}
