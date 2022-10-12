package com.github.fabriciolfj.entrypoint.product.controller;

import com.github.fabriciolfj.business.usecase.FindProduct;
import com.github.fabriciolfj.business.usecase.MergeAllCategoryToProduct;
import com.github.fabriciolfj.business.usecase.SaveProduct;
import com.github.fabriciolfj.entrypoint.product.ProductDtoMapper;
import com.github.fabriciolfj.entrypoint.product.dto.request.ProductRequest;
import com.github.fabriciolfj.entrypoint.product.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final FindProduct findProduct;
    private final SaveProduct saveProduct;
    private final MergeAllCategoryToProduct mergeAllCategoryToProduct;

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCategoryToProduct(@PathVariable("id") final Long id) {
        mergeAllCategoryToProduct.execute(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody final ProductRequest request) {
        var product = ProductDtoMapper.toDomain(request);

        saveProduct.execute(product, request.getCategory());
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductResponse findProduct(@PathVariable("name") final String name) {
        var product = findProduct.execute(name);

        return ProductResponse.builder()
                .price(product.price())
                .describe(product.describe())
                .build();
    }
}
