package com.itdev.electronicsstore.mapper.read;

import com.itdev.electronicsstore.database.entity.products.HardDisk;
import com.itdev.electronicsstore.dto.read.HardDiskReadDto;
import com.itdev.electronicsstore.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class HardDiskReadMapper implements Mapper<HardDisk, HardDiskReadDto> {

    @Override
    public HardDiskReadDto map(HardDisk object) {
        return new HardDiskReadDto(
                object.getId(),
                object.getProduct().getId(),
                object.getCapacity());
    }
}
