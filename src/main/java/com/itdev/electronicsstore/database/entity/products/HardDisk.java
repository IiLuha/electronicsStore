package com.itdev.electronicsstore.database.entity.products;

import com.itdev.electronicsstore.database.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class HardDisk  implements BaseEntity<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;

    private Integer capacity;

    public HardDisk(Integer capacity) {
        this.capacity = capacity;
    }

    public HardDisk() {

    }

    @Override
    public String toString() {
        return "HardDisk{" +
                "id=" + id +
                ", capacity=" + capacity +
                '}';
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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
        product.setDisk(this);
    }
}
