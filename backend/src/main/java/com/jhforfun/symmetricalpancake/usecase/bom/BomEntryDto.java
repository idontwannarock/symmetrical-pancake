package com.jhforfun.symmetricalpancake.usecase.bom;

import java.math.BigDecimal;
import java.util.Objects;

public class BomEntryDto {

    private Integer id;
    private Integer productId;
    private Integer materialId;
    private String materialSerialNumber;
    private String materialName;
    private BigDecimal materialUsage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialSerialNumber() {
        return materialSerialNumber;
    }

    public void setMaterialSerialNumber(String materialSerialNumber) {
        this.materialSerialNumber = materialSerialNumber;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public BigDecimal getMaterialUsage() {
        return materialUsage;
    }

    public void setMaterialUsage(BigDecimal materialUsage) {
        this.materialUsage = materialUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BomEntryDto that = (BomEntryDto) o;
        return Objects.equals(id, that.id) && Objects.equals(productId, that.productId) && Objects.equals(materialId, that.materialId) && Objects.equals(materialSerialNumber, that.materialSerialNumber) && Objects.equals(materialName, that.materialName) && Objects.equals(materialUsage, that.materialUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, materialId, materialSerialNumber, materialName, materialUsage);
    }

    @Override
    public String toString() {
        return "BomEntryDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", materialId=" + materialId +
                ", materialSerialNumber='" + materialSerialNumber + '\'' +
                ", materialName='" + materialName + '\'' +
                ", materialUsage=" + materialUsage +
                '}';
    }
}
