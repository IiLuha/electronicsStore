package com.itdev.electronicsstore.service;

import com.itdev.electronicsstore.database.dao.repositories.DesktopComputerRepository;
import com.itdev.electronicsstore.dto.create.DesktopComputerCreateEditDto;
import com.itdev.electronicsstore.dto.read.DesktopComputerReadDto;
import com.itdev.electronicsstore.mapper.create.DesktopComputerCreateEditMapper;
import com.itdev.electronicsstore.mapper.read.DesktopComputerReadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DesktopComputerService {

    private final DesktopComputerReadMapper desktopComputerReadMapper;
    private final DesktopComputerCreateEditMapper desktopComputerCreateEditMapper;
    private final DesktopComputerRepository desktopComputerRepository;

    public DesktopComputerService(DesktopComputerReadMapper desktopComputerReadMapper, DesktopComputerCreateEditMapper desktopComputerCreateEditMapper, DesktopComputerRepository desktopComputerRepository) {
        this.desktopComputerReadMapper = desktopComputerReadMapper;
        this.desktopComputerCreateEditMapper = desktopComputerCreateEditMapper;
        this.desktopComputerRepository = desktopComputerRepository;
    }

    public Optional<DesktopComputerReadDto> findByProductId(Long productId) {
        return desktopComputerRepository.findByProductId(productId)
                .map(desktopComputerReadMapper::map);
    }

    @Transactional
    public DesktopComputerReadDto create(DesktopComputerCreateEditDto desktopComputerDto) {
        return Optional.of(desktopComputerDto)
                .map(desktopComputerCreateEditMapper::map)
                .map(desktopComputerRepository::save)
                .map(desktopComputerReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<DesktopComputerReadDto> updateByProductId(Long productId, DesktopComputerCreateEditDto desktopComputerDto) {
        return desktopComputerRepository.findByProductId(productId)
                .map(desktopComputer -> desktopComputerCreateEditMapper.map(desktopComputerDto, desktopComputer))
                .map(desktopComputerRepository::saveAndFlush)
                .map(desktopComputerReadMapper::map);
    }
}
