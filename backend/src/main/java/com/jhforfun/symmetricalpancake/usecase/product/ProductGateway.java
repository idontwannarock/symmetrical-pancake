package com.jhforfun.symmetricalpancake.usecase.product;

import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductInput;

import java.util.Optional;

public interface ProductGateway {

    Optional<Integer> create(CreateProductInput input);
}
