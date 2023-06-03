package com.itdev.electronicsstore.database.dao.repositories;

import com.itdev.electronicsstore.database.entity.products.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {

    Optional<Monitor> findByProductId (Long productId);
}
