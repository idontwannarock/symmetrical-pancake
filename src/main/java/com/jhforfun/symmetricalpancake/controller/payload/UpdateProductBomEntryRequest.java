package com.jhforfun.symmetricalpancake.controller.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductBomEntryRequest {

    private Integer materialId;
    private String materialSerialNumber;
    private BigDecimal materialUsage;
}
