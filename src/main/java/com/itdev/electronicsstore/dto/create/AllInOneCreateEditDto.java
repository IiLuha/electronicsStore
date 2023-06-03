package com.itdev.electronicsstore.dto.create;

import com.itdev.electronicsstore.database.entity.fields.ComputerType;
import com.itdev.electronicsstore.database.entity.fields.ProductType;
import com.itdev.electronicsstore.database.entity.fields.Size;

import java.math.BigDecimal;
import java.util.Objects;

public class AllInOneCreateEditDto {

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
