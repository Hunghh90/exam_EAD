package com.example.exam_ead.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long ProdID;
    @Column(name = "prod_name")
    private String ProdName;
    @Column(name = "description")
    private String Description;
    @Column(name = "date_of_manf")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date DateOfManf;
    @Column(name = "price")
    private BigDecimal Price;
    @OneToMany(mappedBy = "product")
    private List<SaleEntity> sales;

public ProductEntity(String ProdName,String Description,Date DateOfManf,BigDecimal Price){
    this.ProdName = ProdName;
    this.Description = Description;
    this.DateOfManf = DateOfManf;
    this.Price = Price;
}
}
