package com.jhforfun.symmetricalpancake.usecase.product.delete;

import com.jhforfun.symmetricalpancake.usecase.CommandOutput;

public interface DeleteProductUseCase {

    void execute(int id, CommandOutput output);
}
