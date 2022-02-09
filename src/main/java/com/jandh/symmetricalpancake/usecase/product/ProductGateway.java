package com.jandh.symmetricalpancake.usecase.product;

import java.util.Optional;

public interface ProductGateway {

    Optional<Integer> create(CreateProductInput input);
}
