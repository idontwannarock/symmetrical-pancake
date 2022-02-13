package com.jhforfun.symmetricalpancake.usecase.product.create;

import com.jhforfun.symmetricalpancake.usecase.CommandOutput;

public interface CreateProductUseCase {

    void execute(CreateProductInput input, CommandOutput output);
}
