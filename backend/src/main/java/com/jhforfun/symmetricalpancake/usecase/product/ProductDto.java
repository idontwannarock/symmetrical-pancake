package com.jhforfun.symmetricalpancake.usecase.product;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDto {

    private Integer id;
    private String serialNumber;
    private String productionType;
    private String name;
    private BigDecimal minimumOrderQuantity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id.equals(that.id) && serialNumber.equals(that.serialNumber) && productionType.equals(that.productionType) && name.equals(that.name) && minimumOrderQuantity.equals(that.minimumOrderQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, productionType, name, minimumOrderQuantity);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", productionType='" + productionType + '\'' +
                ", name='" + name + '\'' +
                ", minimumOrderQuantity=" + minimumOrderQuantity +
                '}';
    }
}
