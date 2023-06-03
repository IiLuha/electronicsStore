package com.itdev.electronicsstore.database.entity.products;

import com.itdev.electronicsstore.database.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Monitor  implements BaseEntity<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;

    private Double diagonal;

    public Monitor(Double diagonal) {
        this.diagonal = diagonal;
    }

    public Monitor(){}

    @Override
    public String toString() {
        return "Monitor{" +
                "id=" + id +
                ", diagonal=" + diagonal +
                '}';
    }

    public Double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public void setId(Long id) {

    }

    @Override
    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        product.setMonitor(this);
    }
}
