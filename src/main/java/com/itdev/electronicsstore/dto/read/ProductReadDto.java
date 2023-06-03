package com.itdev.electronicsstore.dto.read;

import com.itdev.electronicsstore.database.entity.fields.ProductType;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductReadDto {

    private final Long id;
    private final Long serialNumber;
    private final String manufacturer;
    private final BigDecimal price;
    private final Integer quantity;
    private final ProductType productType;
    private final MonitorReadDto monitor;
    private final LaptopReadDto laptop;
    private final HardDiskReadDto disk;
    private final DesktopComputerReadDto computer;

    public ProductReadDto(Long id, Long serialNumber, String manufacturer, BigDecimal price, Integer quantity, ProductType productType, MonitorReadDto monitor, LaptopReadDto laptop, HardDiskReadDto disk, DesktopComputerReadDto computer) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
        this.monitor = monitor;
        this.laptop = laptop;
        this.disk = disk;
        this.computer = computer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductReadDto)) return false;
        ProductReadDto that = (ProductReadDto) o;
        return Objects.equals(id, that.id) && Objects.equals(serialNumber, that.serialNumber) && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(price, that.price) && Objects.equals(quantity, that.quantity) && productType == that.productType && Objects.equals(monitor, that.monitor) && Objects.equals(laptop, that.laptop) && Objects.equals(disk, that.disk) && Objects.equals(computer, that.computer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, manufacturer, price, quantity, productType, monitor, laptop, disk, computer);
    }

    @Override
    public String toString() {
        return "ProductReadDto{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", productType=" + productType +
                ", monitor=" + monitor +
                ", laptop=" + laptop +
                ", disk=" + disk +
                ", computer=" + computer +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductType getType() {
        return productType;
    }

    public MonitorReadDto getMonitor() {
        return monitor;
    }

    public LaptopReadDto getLaptop() {
        return laptop;
    }

    public HardDiskReadDto getDisk() {
        return disk;
    }

    public DesktopComputerReadDto getComputer() {
        return computer;
    }
}
