package com.itdev.electronicsstore.dto.create;

import java.util.Objects;

public class HardDiskCreateEditDto {

    private final Long productId;
    private final Integer capacity;

    public HardDiskCreateEditDto(Long productId, Integer capacity) {
        this.productId = productId;
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HardDiskCreateEditDto)) return false;
        HardDiskCreateEditDto that = (HardDiskCreateEditDto) o;
        return Objects.equals(productId, that.productId) && Objects.equals(capacity, that.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, capacity);
    }

    @Override
    public String toString() {
        return "HardDiskCreateEditDto{" +
                "productId=" + productId +
                ", capacity=" + capacity +
                '}';
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
