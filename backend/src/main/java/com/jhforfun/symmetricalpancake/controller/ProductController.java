package com.jhforfun.symmetricalpancake.controller;

import com.jhforfun.symmetricalpancake.controller.payload.*;
import com.jhforfun.symmetricalpancake.usecase.CommandOutput;
import com.jhforfun.symmetricalpancake.usecase.product.findAllWithEntryCount.FindAllProductWithEntryCountOutput;
import com.jhforfun.symmetricalpancake.usecase.product.findAllWithEntryCount.FindAllProductWithEntryCountUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.findAllWithEntryCount.FindAllProductWithEntryCountUseCaseImpl;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductInput;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductUseCaseImpl;
import com.jhforfun.symmetricalpancake.usecase.product.delete.DeleteProductUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.findAll.FindAllProductUseCaseImpl;
import com.jhforfun.symmetricalpancake.usecase.product.findAll.FindAllProductsOutput;
import com.jhforfun.symmetricalpancake.usecase.product.findAll.FindAllProductsUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.update.UpdateProductInput;
import com.jhforfun.symmetricalpancake.usecase.product.update.UpdateProductUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.update.UpdateProductUseCaseImpl;
import com.jhforfun.symmetricalpancake.util.CommandStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Tag(name = "Product")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final FindAllProductsUseCase findAllProductsUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final FindAllProductWithEntryCountUseCase findAllProductWithEntryCountUseCase;

    @Operation(summary = "Create a product")
    @PostMapping(path = "product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> create(@RequestBody CreateProductRequest payload) {
        CreateProductInput request = new CreateProductUseCaseImpl.CreateProductInputImpl()
                .serialNumber(payload.getSerialNumber())
                .type(payload.getType())
                .name(payload.getName())
                .minimumOrderQuantity(payload.getMinimumOrderQuantity());
        CommandOutput response = new CreateProductResponse();
        createProductUseCase.execute(request, response);
        return ResponseEntity.ok(response.getStatus() == CommandStatus.SUCCESS);
    }

    @Operation(summary = "Retrieve all products")
    @GetMapping(path = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindAllProductsResponse> retrieveAll() {
        FindAllProductsOutput output = new FindAllProductUseCaseImpl.FindAllProductsOutputImpl();
        findAllProductsUseCase.execute(output);
        FindAllProductsResponse response = new FindAllProductsResponse();
        response.setProducts(output.getProducts().stream().map(product -> {
            ProductPayload payload = new ProductPayload();
            payload.setId(product.getId());
            payload.setSerialNumber(product.getSerialNumber());
            payload.setType(product.getProductionType());
            payload.setName(product.getName());
            payload.setMinimumOrderQuantity(product.getMinimumOrderQuantity());
            return payload;
        }).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update a product")
    @PutMapping(path = "product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> update(@RequestBody UpdateProductRequest payload) {
        UpdateProductInput request = new UpdateProductUseCaseImpl.UpdateProductInputImpl()
                .id(payload.getId())
                .serialNumber(payload.getSerialNumber())
                .type(payload.getType())
                .name(payload.getName())
                .minimumOrderQuantity(payload.getMinimumOrderQuantity());
        CommandOutput response = new CreateProductResponse();
        updateProductUseCase.execute(request, response);
        return ResponseEntity.ok(response.getStatus() == CommandStatus.SUCCESS);
    }

    @Operation(summary = "Delete a product")
    @DeleteMapping(path = "product/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        CommandOutput response = new CreateProductResponse();
        deleteProductUseCase.execute(id, response);
        return ResponseEntity.ok(true);
    }

    @Operation(summary = "Retrieve entry count of all products")
    @GetMapping(path = "products/bom/entryCount")
    public ResponseEntity<FindAllProductsWithEntryCountResponse> retrieveAllProductWithEntryCount() {
        FindAllProductWithEntryCountOutput output = new FindAllProductWithEntryCountUseCaseImpl.FindAllProductWithEntryCountOutputImpl();
        findAllProductWithEntryCountUseCase.execute(output);
        FindAllProductsWithEntryCountResponse response = new FindAllProductsWithEntryCountResponse();
        response.setEntryCounts(output.getProductsWithEntryCount().stream().map(entryCount -> {
            ProductWithEntryCountPayload payload = new ProductWithEntryCountPayload();
            payload.setId(entryCount.getId());
            payload.setSerialNumber(entryCount.getSerialNumber());
            payload.setType(entryCount.getType());
            payload.setName(entryCount.getName());
            payload.setEntryCount(entryCount.getEntryCount());
            return payload;
        }).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }
}
