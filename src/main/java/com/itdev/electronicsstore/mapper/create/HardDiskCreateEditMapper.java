package com.itdev.electronicsstore.mapper.create;

import com.itdev.electronicsstore.database.dao.repositories.ProductRepository;
import com.itdev.electronicsstore.database.entity.products.HardDisk;
import com.itdev.electronicsstore.database.entity.products.Product;
import com.itdev.electronicsstore.dto.create.HardDiskCreateEditDto;
import com.itdev.electronicsstore.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HardDiskCreateEditMapper implements Mapper<HardDiskCreateEditDto, HardDisk> {

    private final ProductRepository productRepository;

    public HardDiskCreateEditMapper(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public HardDisk map(HardDiskCreateEditDto object) {
        return map(object, new HardDisk());
    }

    @Override
    public HardDisk map(HardDiskCreateEditDto fromObject, HardDisk toObject) {
        Optional<Product> maybeProduct = productRepository.findById(fromObject.getProductId());
        if (maybeProduct.isPresent()) {
            toObject.setProduct(maybeProduct.get());
            toObject.setCapacity(fromObject.getCapacity());
        }
        return toObject;
    }
}
