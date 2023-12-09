package com.example.exam_ead.service;


import com.example.exam_ead.entities.SaleEntity;

import java.util.List;

public interface SaleService {
    void createSale(SaleEntity sale);
    List<SaleEntity> getAll();
}
