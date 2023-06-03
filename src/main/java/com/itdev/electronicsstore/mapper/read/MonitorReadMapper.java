package com.itdev.electronicsstore.mapper.read;

import com.itdev.electronicsstore.database.entity.products.Monitor;
import com.itdev.electronicsstore.dto.read.MonitorReadDto;
import com.itdev.electronicsstore.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MonitorReadMapper implements Mapper<Monitor, MonitorReadDto> {

    @Override
    public MonitorReadDto map(Monitor object) {
        return new MonitorReadDto(
                object.getId(),
                object.getProduct().getId(),
                object.getDiagonal());
    }
}
