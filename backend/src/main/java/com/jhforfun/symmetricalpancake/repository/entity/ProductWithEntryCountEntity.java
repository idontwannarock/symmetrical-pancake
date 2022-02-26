package com.jhforfun.symmetricalpancake.repository.entity;

import lombok.*;

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
    private Long entryCount;
}
