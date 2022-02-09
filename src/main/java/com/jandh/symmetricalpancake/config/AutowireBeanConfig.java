package com.jandh.symmetricalpancake.config;

import com.jandh.symmetricalpancake.usecase.product.CreateProductUseCase;
import com.jandh.symmetricalpancake.usecase.product.ProductGateway;
import com.jandh.symmetricalpancake.usecase.product.create.CreateProductUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowireBeanConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductGateway productGateway) {
        return new CreateProductUseCaseImpl(productGateway);
    }
}
