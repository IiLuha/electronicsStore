package com.itdev.electronicsstore.dto.read;

import java.math.BigDecimal;
import java.util.Objects;

public class LaptopReadDto {

    private final Long id;
    private final Long productId;
    private final Integer size;

    public LaptopReadDto(Long id, Long productId, Integer size) {
        this.id = id;
        this.productId = productId;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LaptopReadDto)) return false;
        LaptopReadDto that = (LaptopReadDto) o;
        return Objects.equals(id, that.id) && Objects.equals(productId, that.productId) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, size);
    }

    @Override
    public String toString() {
        return "LaptopReadDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", size=" + size +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getSize() {
        return size;
    }
}
