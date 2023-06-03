package com.itdev.electronicsstore.database.dao.repositories;

import com.itdev.electronicsstore.database.entity.products.DesktopComputer;
import com.itdev.electronicsstore.database.entity.products.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DesktopComputerRepository extends JpaRepository<DesktopComputer, Long> {

    Optional<DesktopComputer> findByProductId (Long productId);
}
