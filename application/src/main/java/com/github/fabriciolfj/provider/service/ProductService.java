package com.github.fabriciolfj.provider.service;

import com.github.fabriciolfj.provider.pojo.CategorySumProductPojo;
import jooq.generated.tables.Category;
import jooq.generated.tables.Product;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.jooq.impl.DSL.count;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final DSLContext context;

    public List<CategorySumProductPojo> listSumProduct() {
        return context.select(
                        Category.CATEGORY.NAME.as("describe"),
                        count(Product.PRODUCT.ID).as("total"))
                .from(Category.CATEGORY)
                .innerJoin(Product.PRODUCT)
                .on(Product.PRODUCT.CATEGORY_ID.eq(Category.CATEGORY.ID))
                .groupBy(Category.CATEGORY.NAME)
                .fetchInto(CategorySumProductPojo.class);
    }
}
