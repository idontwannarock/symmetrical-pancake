package com.jhforfun.symmetricalpancake.usecase.product;

import java.util.Objects;

public class ProductWithEntryCountDto {

    private Integer id;
    private String serialNumber;
    private String type;
    private String name;
    private Long entryCount;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEntryCount() {
        return entryCount;
    }

    public void setEntryCount(Long entryCount) {
        this.entryCount = entryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductWithEntryCountDto that = (ProductWithEntryCountDto) o;
        return id.equals(that.id) && serialNumber.equals(that.serialNumber) && type.equals(that.type) && name.equals(that.name) && entryCount.equals(that.entryCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, type, name, entryCount);
    }

    @Override
    public String toString() {
        return "ProductWithEntryCountDto{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", entryCount=" + entryCount +
                '}';
    }
}
