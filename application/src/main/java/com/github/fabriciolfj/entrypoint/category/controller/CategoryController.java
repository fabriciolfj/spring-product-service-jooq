package com.github.fabriciolfj.entrypoint.category.controller;

import com.github.fabriciolfj.business.FindTotalPriceProductPerCategoryProvider;
import com.github.fabriciolfj.business.FindTotalProductCategoryProvider;
import com.github.fabriciolfj.business.usecase.SaveCategory;
import com.github.fabriciolfj.domain.CategoryEntity;
import com.github.fabriciolfj.entrypoint.category.dto.CategoryDTOMapper;
import com.github.fabriciolfj.entrypoint.category.dto.request.CategoryRequest;
import com.github.fabriciolfj.entrypoint.category.dto.response.CategoryPriceResponse;
import com.github.fabriciolfj.entrypoint.category.dto.response.CategoryQuantityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final SaveCategory saveCategory;
    private final FindTotalProductCategoryProvider findTotalProductCategoryProvider;
    private final FindTotalPriceProductPerCategoryProvider findTotalPriceProductPerCategoryProvider;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody final CategoryRequest request) {
        var category = new CategoryEntity(request.getDescribe());
        saveCategory.execute(category);
    }

    @GetMapping("/quantity")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<CategoryQuantityResponse> findQuantityCount() {
        return findTotalProductCategoryProvider.process()
                .stream().map(CategoryDTOMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/price/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CategoryPriceResponse findPriceSum(@PathVariable("name") final String name) {
        var result = findTotalPriceProductPerCategoryProvider.process(name);
        return CategoryDTOMapper.toResponse(result);
    }
}
