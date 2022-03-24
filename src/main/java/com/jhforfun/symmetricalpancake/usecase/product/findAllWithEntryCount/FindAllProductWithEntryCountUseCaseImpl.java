package com.jhforfun.symmetricalpancake.usecase.product.findAllWithEntryCount;

import com.jhforfun.symmetricalpancake.usecase.product.ProductGateway;
import com.jhforfun.symmetricalpancake.usecase.product.ProductWithEntryCountDto;

import java.util.List;

public class FindAllProductWithEntryCountUseCaseImpl implements FindAllProductWithEntryCountUseCase {

    private final ProductGateway productRepository;

    public FindAllProductWithEntryCountUseCaseImpl(ProductGateway entryGateway) {
        this.productRepository = entryGateway;
    }

    @Override
    public void execute(FindAllProductWithEntryCountOutput output) {
        output.setProductsWithEntryCount(productRepository.findAllProductWithEntryCount());
    }

    public static class FindAllProductWithEntryCountOutputImpl implements FindAllProductWithEntryCountOutput {

        private List<ProductWithEntryCountDto> productsWithEntryCount;

        @Override
        public List<ProductWithEntryCountDto> getProductsWithEntryCount() {
            return productsWithEntryCount;
        }

        @Override
        public void setProductsWithEntryCount(List<ProductWithEntryCountDto> productsWithEntryCount) {
            this.productsWithEntryCount = productsWithEntryCount;
        }
    }
}
