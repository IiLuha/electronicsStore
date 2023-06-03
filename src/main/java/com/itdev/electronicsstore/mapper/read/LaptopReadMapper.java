package com.itdev.electronicsstore.mapper.read;

import com.itdev.electronicsstore.database.entity.products.Laptop;
import com.itdev.electronicsstore.dto.read.LaptopReadDto;
import com.itdev.electronicsstore.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class LaptopReadMapper implements Mapper<Laptop, LaptopReadDto> {

    @Override
    public LaptopReadDto map(Laptop object) {
        return new LaptopReadDto(
                object.getId(),
                object.getProduct().getId(),
                object.getSize().getValue());
    }
}
