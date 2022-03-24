package com.jhforfun.symmetricalpancake.usecase.bom;

import java.util.List;

public interface BomGateway {

    List<BomEntryDto> findAllEntriesByProductId(Integer productId);
}
