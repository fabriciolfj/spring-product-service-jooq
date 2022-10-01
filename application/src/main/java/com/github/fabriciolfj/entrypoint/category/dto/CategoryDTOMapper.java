package com.github.fabriciolfj.entrypoint.category.dto;

import com.github.fabriciolfj.domain.CategoryPriceSummaryEntity;
import com.github.fabriciolfj.domain.CategoryQuantitySummaryEntity;
import com.github.fabriciolfj.entrypoint.category.dto.response.CategoryPriceResponse;
import com.github.fabriciolfj.entrypoint.category.dto.response.CategoryQuantityResponse;

public class CategoryDTOMapper {

    private CategoryDTOMapper() {

    }

    public static CategoryPriceResponse toResponse(final CategoryPriceSummaryEntity entity) {
        return CategoryPriceResponse
                .builder()
                .price(entity.price())
                .describe(entity.describe())
                .build();
    }

    public static CategoryQuantityResponse toResponse(final CategoryQuantitySummaryEntity entity) {
        return CategoryQuantityResponse.builder()
                .quantity(entity.quantity())
                .describe(entity.describe())
                .build();
    }
}
