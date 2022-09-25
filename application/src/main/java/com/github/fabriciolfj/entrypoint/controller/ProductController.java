package com.github.fabriciolfj.entrypoint.controller;

import com.github.fabriciolfj.provider.pojo.CategorySumProductPojo;
import com.github.fabriciolfj.provider.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<CategorySumProductPojo> findAllSumCategory() {
        return service.listSumProduct();
    }
}
