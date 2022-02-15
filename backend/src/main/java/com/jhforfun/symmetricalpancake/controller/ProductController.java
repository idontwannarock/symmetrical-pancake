package com.jhforfun.symmetricalpancake.controller;

import com.jhforfun.symmetricalpancake.controller.payload.CreateProductRequest;
import com.jhforfun.symmetricalpancake.controller.payload.CreateProductResponse;
import com.jhforfun.symmetricalpancake.controller.payload.FindAllProductsResponse;
import com.jhforfun.symmetricalpancake.controller.payload.ProductPayload;
import com.jhforfun.symmetricalpancake.usecase.CommandOutput;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductInput;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductUseCaseImpl;
import com.jhforfun.symmetricalpancake.usecase.product.findAll.FindAllProductUseCaseImpl;
import com.jhforfun.symmetricalpancake.usecase.product.findAll.FindAllProductsOutput;
import com.jhforfun.symmetricalpancake.usecase.product.findAll.FindAllProductsUseCase;
import com.jhforfun.symmetricalpancake.util.CommandStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Tag(name = "Product")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final FindAllProductsUseCase findAllProductsUseCase;

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

    @Operation(summary = "Find all products")
    @GetMapping(path = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindAllProductsResponse> findAll() {
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
}
