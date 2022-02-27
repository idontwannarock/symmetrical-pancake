package com.jhforfun.symmetricalpancake.controller;

import com.jhforfun.symmetricalpancake.controller.payload.BomEntryPayload;
import com.jhforfun.symmetricalpancake.controller.payload.FindAllEntriesResponse;
import com.jhforfun.symmetricalpancake.usecase.bom.findAllEntries.FindAllEntriesOfProductOutput;
import com.jhforfun.symmetricalpancake.usecase.bom.findAllEntries.FindAllEntriesOfProductUseCase;
import com.jhforfun.symmetricalpancake.usecase.bom.findAllEntries.FindAllEntriesOfProductUseCaseImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Tag(name = "Product Bom")
@RequiredArgsConstructor
@RestController
public class BomController {

    private final FindAllEntriesOfProductUseCase findAllEntriesOfProductUseCase;

    @Operation(summary = "Retrieve all entries of specific product bom")
    @GetMapping(path = "product/{productId}/bom/entries")
    public ResponseEntity<FindAllEntriesResponse> findAllEntriesByProductId(@PathVariable Integer productId) {
        FindAllEntriesOfProductOutput output = new FindAllEntriesOfProductUseCaseImpl.FindAllEntriesOfProductOutputImpl();
        findAllEntriesOfProductUseCase.execute(productId, output);
        FindAllEntriesResponse response = new FindAllEntriesResponse();
        response.setEntries(output.getAllEntries().stream().map(entry -> {
            BomEntryPayload payload = new BomEntryPayload();
            payload.setId(entry.getId());
            payload.setProductId(entry.getProductId());
            payload.setMaterialId(entry.getMaterialId());
            payload.setMaterialSerialNumber(entry.getMaterialSerialNumber());
            payload.setMaterialName(entry.getMaterialName());
            payload.setMaterialUsage(entry.getMaterialUsage());
            return payload;
        }).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }
}
