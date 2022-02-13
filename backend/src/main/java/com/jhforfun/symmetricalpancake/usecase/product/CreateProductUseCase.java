package com.jhforfun.symmetricalpancake.usecase.product;

import com.jhforfun.symmetricalpancake.usecase.CommandOutput;

public interface CreateProductUseCase {

    void execute(CreateProductInput input, CommandOutput output);
}
