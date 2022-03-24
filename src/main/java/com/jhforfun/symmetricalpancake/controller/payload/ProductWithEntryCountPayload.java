package com.jhforfun.symmetricalpancake.controller.payload;

import lombok.Data;

@Data
public class ProductWithEntryCountPayload {

    private Integer id;
    private String serialNumber;
    private String type;
    private String name;
    private Long entryCount;
}
