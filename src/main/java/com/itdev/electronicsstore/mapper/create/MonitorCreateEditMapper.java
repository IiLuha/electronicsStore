package com.itdev.electronicsstore.mapper.create;

import com.itdev.electronicsstore.database.dao.repositories.ProductRepository;
import com.itdev.electronicsstore.database.entity.products.Monitor;
import com.itdev.electronicsstore.database.entity.products.Product;
import com.itdev.electronicsstore.dto.create.MonitorCreateEditDto;
import com.itdev.electronicsstore.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MonitorCreateEditMapper implements Mapper<MonitorCreateEditDto, Monitor> {

    private final ProductRepository productRepository;

    public MonitorCreateEditMapper(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Monitor map(MonitorCreateEditDto object) {
        return map(object, new Monitor());
    }

    @Override
    public Monitor map(MonitorCreateEditDto fromObject, Monitor toObject) {
        Optional<Product> maybeProduct = productRepository.findById(fromObject.getProductId());
        if (maybeProduct.isPresent()) {
            toObject.setProduct(maybeProduct.get());
            toObject.setDiagonal(fromObject.getDiagonal());
        }
        return toObject;
    }
}
