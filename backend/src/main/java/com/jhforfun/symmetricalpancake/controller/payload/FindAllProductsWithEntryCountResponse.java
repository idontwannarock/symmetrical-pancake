package com.jhforfun.symmetricalpancake.controller.payload;

import lombok.Data;

import java.util.List;

@Data
public class FindAllProductsWithEntryCountResponse {

    private List<ProductWithEntryCountPayload> entryCounts;
}
