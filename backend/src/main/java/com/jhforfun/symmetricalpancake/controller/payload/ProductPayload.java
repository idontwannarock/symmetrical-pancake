package com.jhforfun.symmetricalpancake.controller.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductPayload {

    private Integer id;
    private String serialNumber;
    private String type;
    private String name;
    private BigDecimal minimumOrderQuantity;
}
