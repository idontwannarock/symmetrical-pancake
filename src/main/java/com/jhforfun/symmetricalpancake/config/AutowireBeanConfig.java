package com.jhforfun.symmetricalpancake.config;

import com.jhforfun.symmetricalpancake.usecase.product.CreateProductUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.ProductGateway;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowireBeanConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductGateway productGateway) {
        return new CreateProductUseCaseImpl(productGateway);
    }
}
