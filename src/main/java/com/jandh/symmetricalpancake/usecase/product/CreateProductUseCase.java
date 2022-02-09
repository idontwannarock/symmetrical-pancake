package com.jandh.symmetricalpancake.usecase.product;

import com.jandh.symmetricalpancake.usecase.CommandOutput;

public interface CreateProductUseCase {

    void execute(CreateProductInput input, CommandOutput output);
}
