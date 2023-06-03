package com.itdev.electronicsstore.dto.create;

import com.itdev.electronicsstore.database.entity.fields.ComputerType;
import com.itdev.electronicsstore.database.entity.fields.ProductType;
import com.itdev.electronicsstore.database.entity.fields.Size;

import java.math.BigDecimal;
import java.util.Objects;

public class AllInOneCreateEditDto {

//    private final Long serialNumber;
//    private final String manufacturer;
//    private final BigDecimal price;
//    private final Integer quantity;
//    private final ProductType productType;
//    private final Double diagonal;
//    private final Size size;
//    private final Integer capacity;
//    private final ComputerType computerType;
    private Long serialNumber;
    private String manufacturer;
    private BigDecimal price;
    private Integer quantity;
    private ProductType productType;
    private Double diagonal;
    private Size size;
    private Integer capacity;
    private ComputerType computerType;

    public AllInOneCreateEditDto(){

    }

    public AllInOneCreateEditDto(Long serialNumber, String manufacturer, BigDecimal price, Integer quantity, ProductType productType, Double diagonal, Size size, Integer capacity, ComputerType computerType) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
        this.diagonal = diagonal;
        this.size = size;
        this.capacity = capacity;
        this.computerType = computerType;
    }

    public AllInOneCreateEditDto(Long serialNumber, String manufacturer, BigDecimal price, Integer quantity, ProductType productType, Double diagonal) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
        this.diagonal = diagonal;
        this.size = null;
        this.capacity = null;
        this.computerType = null;
    }

    public AllInOneCreateEditDto(Long serialNumber, String manufacturer, BigDecimal price, Integer quantity, ProductType productType, ComputerType computerType) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
        this.computerType = computerType;
        this.diagonal = null;
        this.size = null;
        this.capacity = null;
    }

    public AllInOneCreateEditDto(Long serialNumber, String manufacturer, BigDecimal price, Integer quantity, ProductType productType, Integer capacity) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
        this.capacity = capacity;
        this.computerType = null;
        this.diagonal = null;
        this.size = null;
    }

    public AllInOneCreateEditDto(Long serialNumber, String manufacturer, BigDecimal price, Integer quantity, ProductType productType, Size size) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
        this.size = size;
        this.capacity = null;
        this.computerType = null;
        this.diagonal = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AllInOneCreateEditDto)) return false;
        AllInOneCreateEditDto that = (AllInOneCreateEditDto) o;
        return Objects.equals(serialNumber, that.serialNumber) && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(price, that.price) && Objects.equals(quantity, that.quantity) && productType == that.productType && Objects.equals(diagonal, that.diagonal) && size == that.size && Objects.equals(capacity, that.capacity) && computerType == that.computerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, manufacturer, price, quantity, productType, diagonal, size, capacity, computerType);
    }

    @Override
    public String toString() {
        return "AllInOneCreateEditDto{" +
                "serialNumber=" + serialNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", productType=" + productType +
                ", diagonal=" + diagonal +
                ", size=" + size +
                ", capacity=" + capacity +
                ", computerType=" + computerType +
                '}';
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

    public ProductType getProductType() {
        return productType;
    }

    public Double getDiagonal() {
        return diagonal;
    }

    public Size getSize() {
        return size;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public ComputerType getComputerType() {
        return computerType;
    }
}
