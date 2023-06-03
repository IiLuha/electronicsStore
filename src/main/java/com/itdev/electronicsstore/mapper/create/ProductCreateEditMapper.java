package com.itdev.electronicsstore.mapper.create;

import com.itdev.electronicsstore.database.entity.products.Product;
import com.itdev.electronicsstore.dto.create.ProductCreateEditDto;
import com.itdev.electronicsstore.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProductCreateEditMapper implements Mapper<ProductCreateEditDto, Product> {

    @Override
    public Product map(ProductCreateEditDto object) {
        return map(object, new Product());
    }

    @Override
    public Product map(ProductCreateEditDto fromObject, Product toObject) {
        toObject.setSerialNumber(fromObject.getSerialNumber());
        toObject.setManufacturer(fromObject.getManufacturer());
        toObject.setPrice(fromObject.getPrice());
        toObject.setQuantity(fromObject.getQuantity());
        toObject.setType(fromObject.getProductType());
        return toObject;
    }

}
