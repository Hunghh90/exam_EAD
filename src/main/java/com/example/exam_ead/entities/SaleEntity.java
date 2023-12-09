package com.example.exam_ead.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sl_no")
    private Long SlNo;
    @Column(name = "sales_man_id")
    private Integer SalesmanID;
//    @Column(name = "prod_id")
//    private Integer ProdId;
    @Column(name = "sales_man_name")
    private String SalesmanName;
    @Column(name = "dos")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date DOS;
    @ManyToOne
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
    private ProductEntity product;
    public SaleEntity(Integer SalesmanID,String SalesmanName,Date DOS,ProductEntity product) {
        this.product = product;
        this.SalesmanID = SalesmanID;
        this.SalesmanName = SalesmanName;
        this.DOS =DOS;
    }

}
