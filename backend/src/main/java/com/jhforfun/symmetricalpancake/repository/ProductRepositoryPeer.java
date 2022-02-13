package com.jhforfun.symmetricalpancake.repository;

import com.jhforfun.symmetricalpancake.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryPeer extends JpaRepository<ProductEntity, Integer> {
}
