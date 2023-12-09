package com.example.exam_ead.service.impl;

import com.example.exam_ead.entities.ProductEntity;
import com.example.exam_ead.entities.SaleEntity;
import com.example.exam_ead.repository.ProductRopesitory;
import com.example.exam_ead.repository.SaleRepository;
import com.example.exam_ead.service.ProductService;
import com.example.exam_ead.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ProductRopesitory productRopesitory;
    @Override
    public void createSale(SaleEntity sale) {
        try{
            saleRepository.save(sale);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<SaleEntity> getAll() {
        return saleRepository.findAll();
    }
}
