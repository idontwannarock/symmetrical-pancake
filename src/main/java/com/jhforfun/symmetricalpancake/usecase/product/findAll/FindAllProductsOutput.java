package com.jhforfun.symmetricalpancake.usecase.product.findAll;

import com.jhforfun.symmetricalpancake.usecase.product.ProductDto;

import java.util.List;

public interface FindAllProductsOutput {

    List<ProductDto> getProducts();

    void setProducts(List<ProductDto> products);
}
