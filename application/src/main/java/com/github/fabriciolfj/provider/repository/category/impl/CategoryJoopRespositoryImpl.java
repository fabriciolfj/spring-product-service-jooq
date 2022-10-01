package com.github.fabriciolfj.provider.repository.category.impl;

import com.github.fabriciolfj.provider.repository.category.CategoryJooqRespository;
import com.github.fabriciolfj.provider.repository.category.pojo.CategorySumPriceProductPojo;
import com.github.fabriciolfj.provider.repository.category.pojo.CategorySumProductPojo;
import jooq.generated.tables.Category;
import jooq.generated.tables.Product;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static org.jooq.impl.DSL.count;
import static org.jooq.impl.DSL.sum;

@Component
@RequiredArgsConstructor
public class CategoryJoopRespositoryImpl implements CategoryJooqRespository {

    private final DSLContext context;

    @Override
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

    @Override
    public Optional<CategorySumPriceProductPojo> sumPriceProduct(final String name) {
        return context.select(
                    Category.CATEGORY.NAME.as("describe"),
                    sum(Product.PRODUCT.PRICE).as("price"))
                .from(Category.CATEGORY)
                .innerJoin(Product.PRODUCT)
                    .on(Product.PRODUCT.CATEGORY_ID.eq(Category.CATEGORY.ID))
                .where(Category.CATEGORY.NAME.eq(name))
                    .groupBy(Category.CATEGORY.NAME)
                .   fetchInto(CategorySumPriceProductPojo.class)
                .stream()
                .findAny();
    }
}
