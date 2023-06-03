package com.itdev.electronicsstore.dto.create;

import com.itdev.electronicsstore.database.entity.fields.ComputerType;

import java.util.Objects;

public class DesktopComputerCreateEditDto {

    private final Long productId;
    private final ComputerType computerType;

    public DesktopComputerCreateEditDto(Long productId, ComputerType computerType) {
        this.productId = productId;
        this.computerType = computerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DesktopComputerCreateEditDto)) return false;
        DesktopComputerCreateEditDto that = (DesktopComputerCreateEditDto) o;
        return Objects.equals(productId, that.productId) && computerType == that.computerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, computerType);
    }

    @Override
    public String toString() {
        return "DesktopComputerCreateEditDto{" +
                "productId=" + productId +
                ", computerType=" + computerType +
                '}';
    }

    public Long getProductId() {
        return productId;
    }

    public ComputerType getComputerType() {
        return computerType;
    }
}
