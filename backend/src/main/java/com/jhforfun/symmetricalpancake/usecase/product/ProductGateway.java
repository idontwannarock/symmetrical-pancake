package com.jhforfun.symmetricalpancake.usecase.product;

import java.util.Optional;

public interface ProductGateway {

    Optional<Integer> create(CreateProductInput input);
}
