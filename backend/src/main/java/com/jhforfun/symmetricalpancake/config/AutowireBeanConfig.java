package com.jhforfun.symmetricalpancake.config;

import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.ProductGateway;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductUseCaseImpl;
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
}
