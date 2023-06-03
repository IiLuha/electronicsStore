package com.itdev.electronicsstore.database.entity.products;

import com.itdev.electronicsstore.database.entity.BaseEntity;
import com.itdev.electronicsstore.database.entity.fields.ComputerType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DesktopComputer  implements BaseEntity<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;

    @Enumerated(EnumType.STRING)
    private ComputerType computerType;

    public DesktopComputer(ComputerType computerType) {
        this.computerType = computerType;
    }

    public DesktopComputer() {

    }

    @Override
    public String toString() {
        return "DesktopComputer{" +
                "id=" + id +
                ", computerType=" + computerType +
                '}';
    }

    public ComputerType getComputerType() {
        return computerType;
    }

    public void setComputerType(ComputerType computerType) {
        this.computerType = computerType;
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
        product.setComputer(this);
    }
}
