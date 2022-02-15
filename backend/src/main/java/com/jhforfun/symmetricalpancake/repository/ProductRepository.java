package com.jhforfun.symmetricalpancake.repository;

import com.jhforfun.symmetricalpancake.repository.entity.ProductEntity;
import com.jhforfun.symmetricalpancake.usecase.product.ProductDto;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductInput;
import com.jhforfun.symmetricalpancake.usecase.product.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class ProductRepository implements ProductGateway {

    private final ProductRepositoryPeer peer;

    @Override
    public Optional<Integer> create(CreateProductInput input) {
        ProductEntity entity = peer.findBySerialNumber(input.getSerialNumber()).orElseGet(ProductEntity::new);
        entity.setSerialNumber(input.getSerialNumber());
        entity.setProductionType(input.getType());
        entity.setName(input.getName());
        entity.setMinimumOrderQuantity(input.getMinimumOrderQuantity());
        entity = peer.save(entity);
        return Optional.of(entity.getId());
    }

    @Override
    public List<ProductDto> findAll() {
        return peer.findAll().stream().map(entity -> {
            ProductDto product = new ProductDto();
            product.setId(entity.getId());
            product.setSerialNumber(entity.getSerialNumber());
            product.setProductionType(entity.getProductionType());
            product.setName(entity.getName());
            product.setMinimumOrderQuantity(entity.getMinimumOrderQuantity());
            return product;
        }).collect(Collectors.toList());
    }
}
