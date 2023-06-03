package com.itdev.electronicsstore.database.dao.repositories;

import com.itdev.electronicsstore.database.entity.products.HardDisk;
import com.itdev.electronicsstore.database.entity.products.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HardDiskRepository extends JpaRepository<HardDisk, Long> {

    Optional<HardDisk> findByProductId (Long productId);
}
