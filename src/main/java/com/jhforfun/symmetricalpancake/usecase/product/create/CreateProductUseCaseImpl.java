package com.jhforfun.symmetricalpancake.usecase.product.create;

import com.jhforfun.symmetricalpancake.usecase.CommandOutput;
import com.jhforfun.symmetricalpancake.usecase.product.CreateProductInput;
import com.jhforfun.symmetricalpancake.usecase.product.CreateProductUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.ProductGateway;
import com.jhforfun.symmetricalpancake.util.CommandStatus;

import java.math.BigDecimal;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductGateway productGateway;

    public CreateProductUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public void execute(CreateProductInput input, CommandOutput output) {
        productGateway.create(input).ifPresentOrElse(productId -> output.setStatus(CommandStatus.SUCCESS), () -> output.setStatus(CommandStatus.FAIL));
    }

    public static class CreateProductInputImpl implements CreateProductInput {

        private String serialNumber;
        private String type;
        private String name;
        private BigDecimal minimumOrderQuantity;

        @Override
        public String getSerialNumber() {
            return serialNumber;
        }

        public CreateProductInputImpl serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        @Override
        public String getType() {
            return type;
        }

        public CreateProductInputImpl type(String type) {
            this.type = type;
            return this;
        }

        @Override
        public String getName() {
            return name;
        }

        public CreateProductInputImpl name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public BigDecimal getMinimumOrderQuantity() {
            return minimumOrderQuantity;
        }

        public CreateProductInputImpl minimumOrderQuantity(BigDecimal minimumOrderQuantity) {
            this.minimumOrderQuantity = minimumOrderQuantity;
            return this;
        }
    }
}
