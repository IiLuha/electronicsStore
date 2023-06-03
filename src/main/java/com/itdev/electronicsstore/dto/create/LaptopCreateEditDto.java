package com.itdev.electronicsstore.dto.create;

import com.itdev.electronicsstore.database.entity.fields.Size;

import java.util.Objects;

public class LaptopCreateEditDto {

    private final Long productId;
    private final Size size;

    public LaptopCreateEditDto(Long productId, Size size) {
        this.productId = productId;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LaptopCreateEditDto)) return false;
        LaptopCreateEditDto that = (LaptopCreateEditDto) o;
        return Objects.equals(productId, that.productId) && size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, size);
    }

    @Override
    public String toString() {
        return "LaptopCreateEditDto{" +
                "productId=" + productId +
                ", size=" + size +
                '}';
    }

    public Long getProductId() {
        return productId;
    }

    public Size getSize() {
        return size;
    }
}
