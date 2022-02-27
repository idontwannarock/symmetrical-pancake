package com.jhforfun.symmetricalpancake.controller.payload;

import lombok.Data;

import java.util.List;

@Data
public class FindAllEntriesResponse {

    private List<BomEntryPayload> entries;
}
