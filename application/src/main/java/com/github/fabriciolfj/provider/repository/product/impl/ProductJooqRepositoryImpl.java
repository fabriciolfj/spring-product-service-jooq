package com.github.fabriciolfj.provider.repository.product.impl;

import com.github.fabriciolfj.provider.repository.product.ProductJooqRepository;
import jooq.generated.tables.Category;
import jooq.generated.tables.Product;
import jooq.generated.tables.records.ProductRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

import static org.jooq.impl.DSL.val;

@Component
@RequiredArgsConstructor
/*
* so oracle e sqlserver dao suporte
* */
public class ProductJooqRepositoryImpl implements ProductJooqRepository {

    private final DSLContext context;

    @Override
    public Optional<ProductRecord> findByName(final String name) {
        return context.selectFrom(Product.PRODUCT)
                .where(Product.PRODUCT.NAME.eq(name))
                .fetch()
                .stream().findAny();
    }

    @Override
    public void addAllCategoriesToProduct(Long productId) {
        context.mergeInto(Product.PRODUCT)
                .using(Category.CATEGORY)
                .on(Category.CATEGORY.ID.eq(Product.PRODUCT.CATEGORY_ID))
                .and(Product.PRODUCT.ID.eq(productId))
                //.whenMatchedThenDelete()
                .whenNotMatchedThenInsert(
                        Product.PRODUCT.PRICE,
                        Product.PRODUCT.CATEGORY_ID,
                        Product.PRODUCT.NAME
                ).values(
                        val(BigDecimal.valueOf(0.0)),
                        Category.CATEGORY.ID,
                        val("Generic")
                ).execute();
    }
}
