package com.itdev.electronicsstore.database.dao.repositories;

import com.itdev.electronicsstore.database.entity.fields.ProductType;
import com.itdev.electronicsstore.database.entity.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductType(ProductType productType);
}
