package com.jhforfun.symmetricalpancake.usecase.bom.findAllEntries;

import com.jhforfun.symmetricalpancake.usecase.bom.BomEntryDto;
import com.jhforfun.symmetricalpancake.usecase.bom.BomGateway;

import java.util.List;

public class FindAllEntriesOfProductUseCaseImpl implements FindAllEntriesOfProductUseCase {

    private final BomGateway bomGateway;

    public FindAllEntriesOfProductUseCaseImpl(BomGateway bomGateway) {
        this.bomGateway = bomGateway;
    }

    @Override
    public void execute(Integer productId, FindAllEntriesOfProductOutput output) {
        output.setAllEntries(bomGateway.findAllEntriesByProductId(productId));
    }

    public static class FindAllEntriesOfProductOutputImpl implements FindAllEntriesOfProductOutput {

        private List<BomEntryDto> entries;

        @Override
        public List<BomEntryDto> getAllEntries() {
            return entries;
        }

        @Override
        public void setAllEntries(List<BomEntryDto> entries) {
            this.entries = entries;
        }
    }
}
