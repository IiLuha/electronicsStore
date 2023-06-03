package com.itdev.electronicsstore.service;

import com.itdev.electronicsstore.database.dao.repositories.MonitorRepository;
import com.itdev.electronicsstore.dto.create.MonitorCreateEditDto;
import com.itdev.electronicsstore.dto.read.MonitorReadDto;
import com.itdev.electronicsstore.mapper.create.MonitorCreateEditMapper;
import com.itdev.electronicsstore.mapper.read.MonitorReadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MonitorService {

    private final MonitorReadMapper monitorReadMapper;
    private final MonitorCreateEditMapper monitorCreateEditMapper;
    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorReadMapper monitorReadMapper, MonitorCreateEditMapper monitorCreateEditMapper, MonitorRepository monitorRepository) {
        this.monitorReadMapper = monitorReadMapper;
        this.monitorCreateEditMapper = monitorCreateEditMapper;
        this.monitorRepository = monitorRepository;
    }

    public Optional<MonitorReadDto> findByProductId(Long productId) {
        return monitorRepository.findByProductId(productId)
                .map(monitorReadMapper::map);
    }

    @Transactional
    public MonitorReadDto create(MonitorCreateEditDto monitorDto) {
        return Optional.of(monitorDto)
                .map(monitorCreateEditMapper::map)
                .map(monitorRepository::save)
                .map(monitorReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<MonitorReadDto> updateByProductId(Long productId, MonitorCreateEditDto monitorDto) {
        return monitorRepository.findByProductId(productId)
                .map(monitor -> monitorCreateEditMapper.map(monitorDto, monitor))
                .map(monitorRepository::saveAndFlush)
                .map(monitorReadMapper::map);
    }
}
