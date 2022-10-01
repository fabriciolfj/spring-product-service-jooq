package com.github.fabriciolfj.provider.repository.product.impl;

import com.github.fabriciolfj.provider.repository.product.ProductJooqRepository;
import jooq.generated.tables.Product;
import jooq.generated.tables.records.ProductRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductJooqRepositoryImpl implements ProductJooqRepository {

    private final DSLContext context;

    @Override
    public Optional<ProductRecord> findByName(final String name) {
        return context.selectFrom(Product.PRODUCT)
                .where(Product.PRODUCT.NAME.eq(name))
                .fetch()
                .stream().findAny();
    }
}
