package com.jhforfun.symmetricalpancake.usecase.product.update;

import java.math.BigDecimal;

public interface UpdateProductInput {

    Integer getId();
    String getSerialNumber();
    String getType();
    String getName();
    BigDecimal getMinimumOrderQuantity();
}
