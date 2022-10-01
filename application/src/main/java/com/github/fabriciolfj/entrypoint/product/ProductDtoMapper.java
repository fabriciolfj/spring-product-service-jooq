package com.github.fabriciolfj.entrypoint.product;

import com.github.fabriciolfj.domain.ProductEntity;
import com.github.fabriciolfj.entrypoint.product.dto.request.ProductRequest;

public class ProductDtoMapper {

    private ProductDtoMapper() { }

    public static ProductEntity toDomain(final ProductRequest request) {
        return new ProductEntity(request.getDescribe(), request.getPrice());
    }
}
