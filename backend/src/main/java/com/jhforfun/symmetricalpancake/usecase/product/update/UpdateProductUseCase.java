package com.jhforfun.symmetricalpancake.usecase.product.update;

import com.jhforfun.symmetricalpancake.usecase.CommandOutput;

public interface UpdateProductUseCase {

    void execute(UpdateProductInput input, CommandOutput output);
}
