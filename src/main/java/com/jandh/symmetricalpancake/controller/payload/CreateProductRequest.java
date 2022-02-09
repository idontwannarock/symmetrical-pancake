package com.jandh.symmetricalpancake.controller.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequest {

    private String serialNumber;
    private String type;
    private String name;
    private BigDecimal minimumOrderQuantity;
}
