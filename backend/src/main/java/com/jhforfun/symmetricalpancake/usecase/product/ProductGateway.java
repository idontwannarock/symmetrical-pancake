package com.jhforfun.symmetricalpancake.usecase.product;

import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductInput;
import com.jhforfun.symmetricalpancake.usecase.product.update.UpdateProductInput;

import java.util.List;
import java.util.Optional;

public interface ProductGateway {

    Optional<Integer> create(CreateProductInput input);

    List<ProductDto> findAll();

    Optional<Integer> update(UpdateProductInput input);

    void delete(int id);
}
