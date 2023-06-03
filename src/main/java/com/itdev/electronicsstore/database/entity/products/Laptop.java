package com.itdev.electronicsstore.database.entity.products;

import com.itdev.electronicsstore.database.entity.BaseEntity;
import com.itdev.electronicsstore.database.entity.fields.Size;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Laptop  implements BaseEntity<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;

    @Enumerated(EnumType.STRING)
    private Size size;

    public Laptop(Size size) {
        this.size = size;
    }

    public Laptop(){}

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
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
        product.setLaptop(this);
    }
}
