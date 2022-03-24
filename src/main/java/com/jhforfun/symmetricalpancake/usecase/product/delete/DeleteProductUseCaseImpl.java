package com.jhforfun.symmetricalpancake.usecase.product.delete;

import com.jhforfun.symmetricalpancake.usecase.CommandOutput;
import com.jhforfun.symmetricalpancake.usecase.product.ProductGateway;
import com.jhforfun.symmetricalpancake.util.CommandStatus;

public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductGateway productGateway;

    public DeleteProductUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public void execute(int id, CommandOutput output) {
        productGateway.delete(id);
        output.setStatus(CommandStatus.SUCCESS);
    }
}
