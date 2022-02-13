package com.jhforfun.symmetricalpancake.controller;

import com.jhforfun.symmetricalpancake.controller.payload.CreateProductRequest;
import com.jhforfun.symmetricalpancake.controller.payload.CreateProductResponse;
import com.jhforfun.symmetricalpancake.usecase.CommandOutput;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductInput;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductUseCase;
import com.jhforfun.symmetricalpancake.usecase.product.create.CreateProductUseCaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ProductController {

    private final CreateProductUseCase createProductUseCase;

    @PostMapping(path = "product")
    public ResponseEntity<Boolean> create(@RequestBody CreateProductRequest payload) {
        CreateProductInput request = new CreateProductUseCaseImpl.CreateProductInputImpl()
                .serialNumber(payload.getSerialNumber())
                .type(payload.getType())
                .name(payload.getName())
                .minimumOrderQuantity(payload.getMinimumOrderQuantity());
        CommandOutput response = new CreateProductResponse();
        createProductUseCase.execute(request, response);
        return ResponseEntity.ok(true);
    }
}
