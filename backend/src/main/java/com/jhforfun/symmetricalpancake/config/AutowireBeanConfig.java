package com.jhforfun.symmetricalpancake.config;

import com.jhforfun.symmetricalpancake.usecase.product.findAllWithEntryCount.FindAllProductWithEntryCountUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.findAllWithEntryCount.FindAllProductWithEntryCountUseCaseImpl;
import com.jhforfun.symmetricalpancake.usecase.product.ProductGateway;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductUseCaseImpl;
import com.jhforfun.symmetricalpancake.usecase.product.delete.DeleteProductUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.delete.DeleteProductUseCaseImpl;
import com.jhforfun.symmetricalpancake.usecase.product.findAll.FindAllProductUseCaseImpl;
import com.jhforfun.symmetricalpancake.usecase.product.findAll.FindAllProductsUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.update.UpdateProductUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.update.UpdateProductUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowireBeanConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductGateway productGateway) {
        return new CreateProductUseCaseImpl(productGateway);
    }

    @Bean
    public FindAllProductsUseCase findAllProductsUseCase(ProductGateway productGateway) {
        return new FindAllProductUseCaseImpl(productGateway);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase(ProductGateway productGateway) {
        return new UpdateProductUseCaseImpl(productGateway);
    }

    @Bean
    public DeleteProductUseCase deleteProductUseCase(ProductGateway productGateway) {
        return new DeleteProductUseCaseImpl(productGateway);
    }

    @Bean
    public FindAllProductWithEntryCountUseCase findAllProductWithEntryCountUseCase(ProductGateway productGateway) {
        return new FindAllProductWithEntryCountUseCaseImpl(productGateway);
    }
}
