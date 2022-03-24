package com.jhforfun.symmetricalpancake.repository;

import com.jhforfun.symmetricalpancake.usecase.bom.BomEntryDto;
import com.jhforfun.symmetricalpancake.usecase.bom.BomGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class BomRepository implements BomGateway {

    private final BomEntryRepositoryPeer peer;

    @Override
    public List<BomEntryDto> findAllEntriesByProductId(Integer productId) {
        return peer.findAllByProductId(productId).stream().map(entry -> {
            BomEntryDto dto = new BomEntryDto();
            dto.setId(entry.getId());
            dto.setProductId(entry.getProduct().getId());
            dto.setMaterialId(entry.getMaterial().getId());
            dto.setMaterialSerialNumber(entry.getMaterial().getSerialNumber());
            dto.setMaterialName(entry.getMaterial().getName());
            dto.setMaterialUsage(entry.getUsage());
            return dto;
        }).collect(Collectors.toList());
    }
}
