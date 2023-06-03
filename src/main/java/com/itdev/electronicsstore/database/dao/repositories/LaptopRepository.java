package com.itdev.electronicsstore.database.dao.repositories;

import com.itdev.electronicsstore.database.entity.products.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    Optional<Laptop> findByProductId (Long productId);
}
