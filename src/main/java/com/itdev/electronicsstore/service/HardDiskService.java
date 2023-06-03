package com.itdev.electronicsstore.service;

import com.itdev.electronicsstore.database.dao.repositories.HardDiskRepository;
import com.itdev.electronicsstore.dto.create.HardDiskCreateEditDto;
import com.itdev.electronicsstore.dto.read.HardDiskReadDto;
import com.itdev.electronicsstore.mapper.create.HardDiskCreateEditMapper;
import com.itdev.electronicsstore.mapper.read.HardDiskReadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class HardDiskService {

    private final HardDiskReadMapper hardDiskReadMapper;
    private final HardDiskCreateEditMapper hardDiskCreateEditMapper;
    private final HardDiskRepository hardDiskRepository;

    public HardDiskService(HardDiskReadMapper hardDiskReadMapper, HardDiskCreateEditMapper hardDiskCreateEditMapper, HardDiskRepository hardDiskRepository) {
        this.hardDiskReadMapper = hardDiskReadMapper;
        this.hardDiskCreateEditMapper = hardDiskCreateEditMapper;
        this.hardDiskRepository = hardDiskRepository;
    }

    public Optional<HardDiskReadDto> findByProductId(Long productId) {
        return hardDiskRepository.findByProductId(productId)
                .map(hardDiskReadMapper::map);
    }

    @Transactional
    public HardDiskReadDto create(HardDiskCreateEditDto hardDiskDto) {
        return Optional.of(hardDiskDto)
                .map(hardDiskCreateEditMapper::map)
                .map(hardDiskRepository::save)
                .map(hardDiskReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<HardDiskReadDto> updateByProductId(Long productId, HardDiskCreateEditDto hardDiskDto) {
        return hardDiskRepository.findByProductId(productId)
                .map(hardDisk -> hardDiskCreateEditMapper.map(hardDiskDto, hardDisk))
                .map(hardDiskRepository::saveAndFlush)
                .map(hardDiskReadMapper::map);
    }
}
