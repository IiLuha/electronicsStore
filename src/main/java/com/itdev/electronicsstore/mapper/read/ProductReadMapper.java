package com.itdev.electronicsstore.mapper.read;

import com.itdev.electronicsstore.database.entity.products.Product;
import com.itdev.electronicsstore.dto.read.DesktopComputerReadDto;
import com.itdev.electronicsstore.dto.read.HardDiskReadDto;
import com.itdev.electronicsstore.dto.read.LaptopReadDto;
import com.itdev.electronicsstore.dto.read.MonitorReadDto;
import com.itdev.electronicsstore.dto.read.ProductReadDto;
import com.itdev.electronicsstore.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductReadMapper implements Mapper<Product, ProductReadDto> {

    private final DesktopComputerReadMapper computerReadMapper;
    private final HardDiskReadMapper diskReadMapper;
    private final LaptopReadMapper laptopReadMapper;
    private final MonitorReadMapper monitorReadMapper;

    public ProductReadMapper(DesktopComputerReadMapper computerReadMapper, HardDiskReadMapper diskReadMapper, LaptopReadMapper laptopReadMapper, MonitorReadMapper monitorReadMapper) {
        this.computerReadMapper = computerReadMapper;
        this.diskReadMapper = diskReadMapper;
        this.laptopReadMapper = laptopReadMapper;
        this.monitorReadMapper = monitorReadMapper;
    }

    @Override
    public ProductReadDto map(Product object) {
        DesktopComputerReadDto computerReadDto = Optional.ofNullable(object.getComputer()).map(computerReadMapper::map).orElse(null);
        HardDiskReadDto diskReadDto = Optional.ofNullable(object.getDisk()).map(diskReadMapper::map).orElse(null);
        LaptopReadDto laptopReadDto = Optional.ofNullable(object.getLaptop()).map(laptopReadMapper::map).orElse(null);
        MonitorReadDto monitorReadDto = Optional.ofNullable(object.getMonitor()).map(monitorReadMapper::map).orElse(null);
        return new ProductReadDto(
                object.getId(),
                object.getSerialNumber(),
                object.getManufacturer(),
                object.getPrice(),
                object.getQuantity(),
                object.getType(),
                monitorReadDto,
                laptopReadDto,
                diskReadDto,
                computerReadDto);
    }
}
