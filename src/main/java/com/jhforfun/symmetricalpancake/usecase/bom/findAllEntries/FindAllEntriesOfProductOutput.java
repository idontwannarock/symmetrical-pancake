package com.jhforfun.symmetricalpancake.usecase.bom.findAllEntries;

import com.jhforfun.symmetricalpancake.usecase.bom.BomEntryDto;

import java.util.List;

public interface FindAllEntriesOfProductOutput {

    List<BomEntryDto> getAllEntries();

    void setAllEntries(List<BomEntryDto> entries);
}
