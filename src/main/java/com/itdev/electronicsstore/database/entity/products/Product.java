package com.itdev.electronicsstore.database.entity.products;

import com.itdev.electronicsstore.database.entity.BaseEntity;
import com.itdev.electronicsstore.database.entity.fields.ProductType;
import org.springframework.lang.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(
        name="product",
        uniqueConstraints = @UniqueConstraint(columnNames={"id"})
)
public class Product implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long serialNumber;
    private String manufacturer;
    private BigDecimal price;
    private Integer quantity;

    @NonNull
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Monitor monitor;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Laptop laptop;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private HardDisk disk;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private DesktopComputer computer;

    public Product(Long id, Long serialNumber, String manufacturer, BigDecimal price, Integer quantity, @NonNull ProductType productType) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
    }

    public Product() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(serialNumber, product.serialNumber) && Objects.equals(manufacturer, product.manufacturer) && Objects.equals(price, product.price) && Objects.equals(quantity, product.quantity) && productType == product.productType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, manufacturer, price, quantity, productType);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", productType=" + productType +
                '}';
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public HardDisk getDisk() {
        return disk;
    }

    public void setDisk(HardDisk disk) {
        this.disk = disk;
    }

    public DesktopComputer getComputer() {
        return computer;
    }

    public void setComputer(DesktopComputer computer) {
        this.computer = computer;
    }

    @NonNull
    public ProductType getType() {
        return productType;
    }

    public void setType(@NonNull ProductType productType) {
        this.productType = productType;
    }
}
