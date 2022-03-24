package com.jhforfun.symmetricalpancake.controller.payload;

import lombok.Data;

import java.util.List;

@Data
public class FindAllProductsResponse {

    private List<ProductPayload> products;
}
