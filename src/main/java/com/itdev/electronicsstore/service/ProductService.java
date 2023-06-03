package com.itdev.electronicsstore.service;

import com.itdev.electronicsstore.database.dao.repositories.ProductRepository;
import com.itdev.electronicsstore.database.entity.fields.ProductType;
import com.itdev.electronicsstore.dto.create.ProductCreateEditDto;
import com.itdev.electronicsstore.dto.read.ProductReadDto;
import com.itdev.electronicsstore.mapper.create.ProductCreateEditMapper;
import com.itdev.electronicsstore.mapper.read.ProductReadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductReadMapper productReadMapper;
    private final ProductCreateEditMapper productCreateEditMapper;
    private final ProductRepository productRepository;

    public ProductService(ProductReadMapper productReadMapper, ProductCreateEditMapper productCreateEditMapper, ProductRepository productRepository) {
        this.productReadMapper = productReadMapper;
        this.productCreateEditMapper = productCreateEditMapper;
        this.productRepository = productRepository;
    }

    public Optional<ProductReadDto> findById(Long id) {
        return productRepository.findById(id)
                .map(productReadMapper::map);
    }

    public List<ProductReadDto> findByType(ProductType productType) {
        List<ProductReadDto> result = new ArrayList<>();
        productRepository.findByProductType(productType).stream()
                .map(productReadMapper::map)
                .forEach(result::add);
        return result;
    }

    @Transactional
    public ProductReadDto create(ProductCreateEditDto productDto) {
        return Optional.of(productDto)
                .map(productCreateEditMapper::map)
                .map(productRepository::save)
                .map(productReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<ProductReadDto> update(Long id, ProductCreateEditDto productDto) {
        return productRepository.findById(id)
                .map(product -> productCreateEditMapper.map(productDto, product))
                .map(productRepository::saveAndFlush)
                .map(productReadMapper::map);
    }
}
