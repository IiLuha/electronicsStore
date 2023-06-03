package com.itdev.electronicsstore.dto.create;

import com.itdev.electronicsstore.database.entity.fields.ProductType;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductCreateEditDto {

    private final Long serialNumber;
    private final String manufacturer;
    private final BigDecimal price;
    private final Integer quantity;
    private final ProductType productType;

    public ProductCreateEditDto(Long serialNumber, String manufacturer, BigDecimal price, Integer quantity, ProductType productType) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCreateEditDto)) return false;
        ProductCreateEditDto that = (ProductCreateEditDto) o;
        return Objects.equals(serialNumber, that.serialNumber) && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(price, that.price) && Objects.equals(quantity, that.quantity) && productType == that.productType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, manufacturer, price, quantity, productType);
    }

    @Override
    public String toString() {
        return "ProductCreateEditDto{" +
                "serialNumber=" + serialNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", productType=" + productType +
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
}
