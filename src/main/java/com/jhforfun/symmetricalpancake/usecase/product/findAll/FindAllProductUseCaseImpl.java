package com.jhforfun.symmetricalpancake.usecase.product.findAll;

import com.jhforfun.symmetricalpancake.usecase.product.ProductDto;
import com.jhforfun.symmetricalpancake.usecase.product.ProductGateway;

import java.util.List;

public class FindAllProductUseCaseImpl implements FindAllProductsUseCase {

    private final ProductGateway productGateway;

    public FindAllProductUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public void execute(FindAllProductsOutput output) {
        output.setProducts(productGateway.findAll());
    }

    public static class FindAllProductsOutputImpl implements FindAllProductsOutput {

        private List<ProductDto> products;

        @Override
        public void setProducts(List<ProductDto> products) {
            this.products = products;
        }

        @Override
        public List<ProductDto> getProducts() {
            return products;
        }
    }
}
