package com.itdev.electronicsstore.mapper.read;

import com.itdev.electronicsstore.database.entity.products.DesktopComputer;
import com.itdev.electronicsstore.dto.read.DesktopComputerReadDto;
import com.itdev.electronicsstore.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class DesktopComputerReadMapper implements Mapper<DesktopComputer, DesktopComputerReadDto> {

    @Override
    public DesktopComputerReadDto map(DesktopComputer object) {
        return new DesktopComputerReadDto(
                object.getId(),
                object.getProduct().getId(),
                object.getComputerType().name());
    }
}
