package com.jhforfun.symmetricalpancake.repository;

import com.jhforfun.symmetricalpancake.repository.entity.BomEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BomEntryRepositoryPeer extends JpaRepository<BomEntryEntity, Integer> {

    List<BomEntryEntity> findAllByProductId(Integer productId);
}
