package com.github.fabriciolfj.provider.service.category;

import com.github.fabriciolfj.domain.CategoryPriceSummaryEntity;
import com.github.fabriciolfj.domain.CategoryQuantitySummaryEntity;
import com.github.fabriciolfj.entities.Category;
import com.github.fabriciolfj.provider.repository.category.pojo.CategorySumPriceProductPojo;
import com.github.fabriciolfj.provider.repository.category.pojo.CategorySumProductPojo;
import jooq.generated.tables.records.CategoryRecord;

public class CategoryMapper {

    private CategoryMapper() {

    }

    public static CategoryPriceSummaryEntity toDomain(final CategorySumPriceProductPojo pojo) {
        return new CategoryPriceSummaryEntity(pojo.getDescribe(), pojo.getPrice());
    }

    public static CategoryQuantitySummaryEntity toDomain(final CategorySumProductPojo pojo) {
        return new CategoryQuantitySummaryEntity(pojo.getDescribe(), pojo.getTotal());
    }

    public static CategoryRecord toData(final String name) {
        var record = new CategoryRecord();
        record.setName(name);

        return record;
    }
}
