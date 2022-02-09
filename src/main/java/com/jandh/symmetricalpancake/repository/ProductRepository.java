package com.jandh.symmetricalpancake.repository;

import com.jandh.symmetricalpancake.repository.entity.ProductEntity;
import com.jandh.symmetricalpancake.usecase.product.CreateProductInput;
import com.jandh.symmetricalpancake.usecase.product.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProductRepository implements ProductGateway {

    private final ProductRepositoryPeer peer;

    @Override
    public Optional<Integer> create(CreateProductInput input) {
        LocalDateTime now = LocalDateTime.now();
        ProductEntity entity = new ProductEntity();
        entity.setSerialNumber(input.getSerialNumber());
        entity.setProductionType(input.getType());
        entity.setName(input.getName());
        entity.setMinimumOrderQuantity(input.getMinimumOrderQuantity());
        entity.setCreateTime(now);
        entity.setUpdateTime(now);
        entity = peer.save(entity);
        return Optional.of(entity.getId());
    }
}
