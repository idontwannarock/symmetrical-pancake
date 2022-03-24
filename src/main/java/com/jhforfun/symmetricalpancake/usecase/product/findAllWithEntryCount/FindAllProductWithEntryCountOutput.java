package com.jhforfun.symmetricalpancake.usecase.product.findAllWithEntryCount;

import com.jhforfun.symmetricalpancake.usecase.product.ProductWithEntryCountDto;

import java.util.List;

public interface FindAllProductWithEntryCountOutput {

    List<ProductWithEntryCountDto> getProductsWithEntryCount();

    void setProductsWithEntryCount(List<ProductWithEntryCountDto> entryCounts);
}
