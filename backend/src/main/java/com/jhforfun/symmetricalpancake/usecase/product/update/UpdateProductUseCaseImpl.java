package com.jhforfun.symmetricalpancake.usecase.product.update;

import com.jhforfun.symmetricalpancake.usecase.CommandOutput;
import com.jhforfun.symmetricalpancake.usecase.product.ProductGateway;
import com.jhforfun.symmetricalpancake.util.CommandStatus;

import java.math.BigDecimal;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductGateway productGateway;

    public UpdateProductUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public void execute(UpdateProductInput input, CommandOutput output) {
        productGateway.update(input).ifPresentOrElse(productId -> output.setStatus(CommandStatus.SUCCESS), () -> output.setStatus(CommandStatus.FAIL));
    }

    public static class UpdateProductInputImpl implements UpdateProductInput {

        private Integer id;
        private String serialNumber;
        private String type;
        private String name;
        private BigDecimal minimumOrderQuantity;

        @Override
        public Integer getId() {
            return id;
        }

        public UpdateProductUseCaseImpl.UpdateProductInputImpl id(Integer id) {
            this.id = id;
            return this;
        }

        @Override
        public String getSerialNumber() {
            return serialNumber;
        }

        public UpdateProductUseCaseImpl.UpdateProductInputImpl serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        @Override
        public String getType() {
            return type;
        }

        public UpdateProductUseCaseImpl.UpdateProductInputImpl type(String type) {
            this.type = type;
            return this;
        }

        @Override
        public String getName() {
            return name;
        }

        public UpdateProductUseCaseImpl.UpdateProductInputImpl name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public BigDecimal getMinimumOrderQuantity() {
            return minimumOrderQuantity;
        }

        public UpdateProductUseCaseImpl.UpdateProductInputImpl minimumOrderQuantity(BigDecimal minimumOrderQuantity) {
            this.minimumOrderQuantity = minimumOrderQuantity;
            return this;
        }
    }
}
