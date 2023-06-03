package com.itdev.electronicsstore.service;

import com.itdev.electronicsstore.database.dao.repositories.DesktopComputerRepository;
import com.itdev.electronicsstore.database.dao.repositories.HardDiskRepository;
import com.itdev.electronicsstore.database.dao.repositories.LaptopRepository;
import com.itdev.electronicsstore.database.dao.repositories.LaptopRepository;
import com.itdev.electronicsstore.database.dao.repositories.ProductRepository;
import com.itdev.electronicsstore.dto.create.LaptopCreateEditDto;
import com.itdev.electronicsstore.dto.read.LaptopReadDto;
import com.itdev.electronicsstore.mapper.create.DesktopComputerCreateEditMapper;
import com.itdev.electronicsstore.mapper.create.HardDiskCreateEditMapper;
import com.itdev.electronicsstore.mapper.create.LaptopCreateEditMapper;
import com.itdev.electronicsstore.mapper.create.LaptopCreateEditMapper;
import com.itdev.electronicsstore.mapper.create.ProductCreateEditMapper;
import com.itdev.electronicsstore.mapper.read.DesktopComputerReadMapper;
import com.itdev.electronicsstore.mapper.read.HardDiskReadMapper;
import com.itdev.electronicsstore.mapper.read.LaptopReadMapper;
import com.itdev.electronicsstore.mapper.read.LaptopReadMapper;
import com.itdev.electronicsstore.mapper.read.ProductReadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class LaptopService {

    private final LaptopReadMapper laptopReadMapper;
    private final LaptopCreateEditMapper laptopCreateEditMapper;
    private final LaptopRepository laptopRepository;

    public LaptopService(LaptopReadMapper laptopReadMapper, LaptopCreateEditMapper laptopCreateEditMapper, LaptopRepository laptopRepository) {
        this.laptopReadMapper = laptopReadMapper;
        this.laptopCreateEditMapper = laptopCreateEditMapper;
        this.laptopRepository = laptopRepository;
    }

    public Optional<LaptopReadDto> findByProductId(Long productId) {
        return laptopRepository.findByProductId(productId)
                .map(laptopReadMapper::map);
    }

    @Transactional
    public LaptopReadDto create(LaptopCreateEditDto laptopDto) {
        return Optional.of(laptopDto)
                .map(laptopCreateEditMapper::map)
                .map(laptopRepository::save)
                .map(laptopReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<LaptopReadDto> updateByProductId(Long productId, LaptopCreateEditDto laptopDto) {
        return laptopRepository.findByProductId(productId)
                .map(laptop -> laptopCreateEditMapper.map(laptopDto, laptop))
                .map(laptopRepository::saveAndFlush)
                .map(laptopReadMapper::map);
    }
}
