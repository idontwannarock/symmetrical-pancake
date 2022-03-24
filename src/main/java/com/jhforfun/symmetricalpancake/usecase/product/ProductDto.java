package com.jhforfun.symmetricalpancake.usecase.product;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDto {

    private Integer id;
    private String serialNumber;
    private String productionType;
    private String name;
    private BigDecimal minimumOrderQuantity;
    private Long bomEntryCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProductionType() {
        return productionType;
    }

    public void setProductionType(String productionType) {
        this.productionType = productionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(BigDecimal minimumOrderQuantity) {
        this.minimumOrderQuantity = minimumOrderQuantity;
    }

    public Long getBomEntryCount() {
        return bomEntryCount;
    }

    public void setBomEntryCount(Long bomEntryCount) {
        this.bomEntryCount = bomEntryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto)) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getSerialNumber(), that.getSerialNumber()) && Objects.equals(getProductionType(), that.getProductionType()) && Objects.equals(getName(), that.getName()) && Objects.equals(getMinimumOrderQuantity(), that.getMinimumOrderQuantity()) && Objects.equals(getBomEntryCount(), that.getBomEntryCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSerialNumber(), getProductionType(), getName(), getMinimumOrderQuantity(), getBomEntryCount());
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", productionType='" + productionType + '\'' +
                ", name='" + name + '\'' +
                ", minimumOrderQuantity=" + minimumOrderQuantity +
                ", bomEntryCount=" + bomEntryCount +
                '}';
    }
}
