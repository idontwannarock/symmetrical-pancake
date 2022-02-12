package com.jhforfun.symmetricalpancake.usecase.product;

import java.math.BigDecimal;

public interface CreateProductInput {

    String getSerialNumber();
    String getType();
    String getName();
    BigDecimal getMinimumOrderQuantity();
}
