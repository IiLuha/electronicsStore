package com.itdev.electronicsstore.dto.create;

import java.util.Objects;

public class MonitorCreateEditDto {

    private final Long productId;
    private final Double diagonal;

    public MonitorCreateEditDto(Long productId, Double diagonal) {
        this.productId = productId;
        this.diagonal = diagonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonitorCreateEditDto)) return false;
        MonitorCreateEditDto that = (MonitorCreateEditDto) o;
        return Objects.equals(productId, that.productId) && Objects.equals(diagonal, that.diagonal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, diagonal);
    }

    @Override
    public String toString() {
        return "MonitorCreateEditDto{" +
                "productId=" + productId +
                ", diagonal=" + diagonal +
                '}';
    }

    public Long getProductId() {
        return productId;
    }

    public Double getDiagonal() {
        return diagonal;
    }
}
