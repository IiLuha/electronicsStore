package com.itdev.electronicsstore.mapper.create;

import com.itdev.electronicsstore.database.dao.repositories.ProductRepository;
import com.itdev.electronicsstore.database.entity.products.Laptop;
import com.itdev.electronicsstore.database.entity.products.Product;
import com.itdev.electronicsstore.dto.create.LaptopCreateEditDto;
import com.itdev.electronicsstore.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LaptopCreateEditMapper implements Mapper<LaptopCreateEditDto, Laptop> {

    private final ProductRepository productRepository;

    public LaptopCreateEditMapper(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Laptop map(LaptopCreateEditDto object) {
        return map(object, new Laptop());
    }

    @Override
    public Laptop map(LaptopCreateEditDto fromObject, Laptop toObject) {
        Optional<Product> maybeProduct = productRepository.findById(fromObject.getProductId());
        if (maybeProduct.isPresent()) {
            toObject.setProduct(maybeProduct.get());
            toObject.setSize(fromObject.getSize());
        }
        return toObject;
    }
}
