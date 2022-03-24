package com.jhforfun.symmetricalpancake.controller.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BomEntryPayload {

    private Integer id;
    private Integer productId;
    private Integer materialId;
    private String materialSerialNumber;
    private String materialName;
    private BigDecimal materialUsage;
}
