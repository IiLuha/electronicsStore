package com.itdev.electronicsstore.dto.read;

import java.util.Objects;

public class HardDiskReadDto{

    private final Long id;
    private final Long productId;
    private final Integer capacity;

    public HardDiskReadDto(Long id, Long productId, Integer capacity) {
        this.id = id;
        this.productId = productId;
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HardDiskReadDto)) return false;
        HardDiskReadDto that = (HardDiskReadDto) o;
        return Objects.equals(id, that.id) && Objects.equals(productId, that.productId) && Objects.equals(capacity, that.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, capacity);
    }

    @Override
    public String toString() {
        return "HardDiskReadDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", capacity=" + capacity +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
