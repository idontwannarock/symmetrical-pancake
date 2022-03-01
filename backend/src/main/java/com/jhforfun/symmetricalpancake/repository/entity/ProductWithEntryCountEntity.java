package com.jhforfun.symmetricalpancake.repository.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductWithEntryCountEntity {

    private Integer id;
    private String serialNumber;
    private String productionType;
    private String name;
    private BigDecimal minimumOrderQuantity;
    private Long entryCount;
}
