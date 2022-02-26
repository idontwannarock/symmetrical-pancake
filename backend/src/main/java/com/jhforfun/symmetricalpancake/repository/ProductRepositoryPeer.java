package com.jhforfun.symmetricalpancake.repository;

import com.jhforfun.symmetricalpancake.repository.entity.ProductEntity;
import com.jhforfun.symmetricalpancake.repository.entity.ProductWithEntryCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepositoryPeer extends JpaRepository<ProductEntity, Integer> {

    Optional<ProductEntity> findBySerialNumber(String serialNumber);

    @Query("SELECT new com.jhforfun.symmetricalpancake.repository.entity.ProductWithEntryCountEntity(p.id, p.serialNumber, p.productionType, p.name, COUNT(b.id)) " +
            "FROM ProductEntity AS p LEFT JOIN BomEntryEntity AS b ON p.id = b.product.id " +
            "GROUP BY p.id, p.serialNumber, p.productionType, p.name ")
    List<ProductWithEntryCountEntity> findAllProductWithEntryCount();
}
