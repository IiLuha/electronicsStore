package com.itdev.electronicsstore.http.rest;

import com.itdev.electronicsstore.database.entity.fields.ProductType;
import com.itdev.electronicsstore.dto.create.AllInOneCreateEditDto;
import com.itdev.electronicsstore.dto.create.DesktopComputerCreateEditDto;
import com.itdev.electronicsstore.dto.create.HardDiskCreateEditDto;
import com.itdev.electronicsstore.dto.create.LaptopCreateEditDto;
import com.itdev.electronicsstore.dto.create.MonitorCreateEditDto;
import com.itdev.electronicsstore.dto.create.ProductCreateEditDto;
import com.itdev.electronicsstore.dto.read.HardDiskReadDto;
import com.itdev.electronicsstore.dto.read.ProductReadDto;
import com.itdev.electronicsstore.service.DesktopComputerService;
import com.itdev.electronicsstore.service.HardDiskService;
import com.itdev.electronicsstore.service.LaptopService;
import com.itdev.electronicsstore.service.MonitorService;
import com.itdev.electronicsstore.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    private final LaptopService laptopService;
    private final DesktopComputerService desktopComputerService;
    private final MonitorService monitorService;
    private final HardDiskService hardDiskService;
    private final ProductService productService;

    public ProductRestController(LaptopService laptopService, DesktopComputerService desktopComputerService, MonitorService monitorService, HardDiskService hardDiskService, ProductService productService) {
        this.laptopService = laptopService;
        this.desktopComputerService = desktopComputerService;
        this.monitorService = monitorService;
        this.hardDiskService = hardDiskService;
        this.productService = productService;
    }

    @GetMapping
    public List<ProductReadDto> findByType(ProductType productType) {
        return productService.findByType(productType);
    }

    @GetMapping("/{id}")
    public ProductReadDto findById(@PathVariable("id") Long id) {
        return productService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductReadDto create(@RequestBody AllInOneCreateEditDto all) {
        ProductCreateEditDto product = getProduct(all);
        Long id = productService.create(product).getId();
        HardDiskReadDto diskReadDto = new HardDiskReadDto(2000L,2000L,2000);
        if (all.getDiagonal() != null){
            MonitorCreateEditDto monitor = new MonitorCreateEditDto(id, all.getDiagonal());
            monitorService.create(monitor);
        } else if (all.getCapacity() != null) {
            HardDiskCreateEditDto disk = new HardDiskCreateEditDto(id, all.getCapacity());
            diskReadDto = hardDiskService.create(disk);
        } else if (all.getComputerType() != null) {
            DesktopComputerCreateEditDto computer = new DesktopComputerCreateEditDto(id, all.getComputerType());
            desktopComputerService.create(computer);
        } else if (all.getSize() != null) {
            LaptopCreateEditDto laptop = new LaptopCreateEditDto(id, all.getSize());
            laptopService.create(laptop);
        }
        System.out.println(diskReadDto);
        return productService.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public ProductReadDto update(@PathVariable("id") Long id, @RequestBody AllInOneCreateEditDto all) {
        ProductCreateEditDto product = getProduct(all);
        if (productService.update(id, product).isPresent()) {
            if (all.getDiagonal() != null) {
                MonitorCreateEditDto monitor = new MonitorCreateEditDto(id, all.getDiagonal());
                monitorService.updateByProductId(id, monitor)
                        .orElse(monitorService.create(monitor));
            } else if (all.getCapacity() != null) {
                HardDiskCreateEditDto disk = new HardDiskCreateEditDto(id, all.getCapacity());
                hardDiskService.updateByProductId(id, disk)
                        .orElse(hardDiskService.create(disk));
            } else if (all.getComputerType() != null) {
                DesktopComputerCreateEditDto computer = new DesktopComputerCreateEditDto(id, all.getComputerType());
                desktopComputerService.updateByProductId(id, computer)
                        .orElse(desktopComputerService.create(computer));
            } else if (all.getSize() != null) {
                LaptopCreateEditDto laptop = new LaptopCreateEditDto(id, all.getSize());
                laptopService.updateByProductId(id, laptop)
                        .orElse(laptopService.create(laptop));
            }
        }
        return productService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private static ProductCreateEditDto getProduct(AllInOneCreateEditDto all) {
        return new ProductCreateEditDto(
                all.getSerialNumber(),
                all.getManufacturer(),
                all.getPrice(),
                all.getQuantity(),
                all.getProductType()
        );
    }
}
