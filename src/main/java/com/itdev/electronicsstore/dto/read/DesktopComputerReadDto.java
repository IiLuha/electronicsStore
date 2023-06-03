package com.itdev.electronicsstore.dto.read;

import java.math.BigDecimal;
import java.util.Objects;

public class DesktopComputerReadDto {

    private final Long id;
    private final Long productId;
    private final String computerType;

    public DesktopComputerReadDto(Long id, Long productId, String computerType) {
        this.id = id;
        this.productId = productId;
        this.computerType = computerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DesktopComputerReadDto)) return false;
        DesktopComputerReadDto that = (DesktopComputerReadDto) o;
        return Objects.equals(id, that.id) && Objects.equals(productId, that.productId) && Objects.equals(computerType, that.computerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, computerType);
    }

    @Override
    public String toString() {
        return "DesktopComputerReadDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", computerType='" + computerType + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public String getComputerType() {
        return computerType;
    }
}
