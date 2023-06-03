package com.itdev.electronicsstore.mapper.create;

import com.itdev.electronicsstore.database.dao.repositories.ProductRepository;
import com.itdev.electronicsstore.database.entity.products.DesktopComputer;
import com.itdev.electronicsstore.database.entity.products.Product;
import com.itdev.electronicsstore.dto.create.DesktopComputerCreateEditDto;
import com.itdev.electronicsstore.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DesktopComputerCreateEditMapper implements Mapper<DesktopComputerCreateEditDto, DesktopComputer> {

    private final ProductRepository productRepository;

    public DesktopComputerCreateEditMapper(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public DesktopComputer map(DesktopComputerCreateEditDto object) {
        return map(object, new DesktopComputer());
    }

    @Override
    public DesktopComputer map(DesktopComputerCreateEditDto fromObject, DesktopComputer toObject) {
        Optional<Product> maybeProduct = productRepository.findById(fromObject.getProductId());
        if (maybeProduct.isPresent()) {
            toObject.setProduct(maybeProduct.get());
            toObject.setComputerType(fromObject.getComputerType());
        }
        return toObject;
    }

}
