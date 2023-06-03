package com.itdev.electronicsstore.dto.read;

import java.util.Objects;

public class MonitorReadDto {

    private final Long id;
    private final Long productId;
    private final Double diagonal;

    public MonitorReadDto(Long id, Long productId, Double diagonal) {
        this.id = id;
        this.productId = productId;
        this.diagonal = diagonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonitorReadDto)) return false;
        MonitorReadDto that = (MonitorReadDto) o;
        return Objects.equals(id, that.id) && Objects.equals(productId, that.productId) && Objects.equals(diagonal, that.diagonal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, diagonal);
    }

    @Override
    public String toString() {
        return "MonitorReadDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", diagonal=" + diagonal +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Double getDiagonal() {
        return diagonal;
    }
}
