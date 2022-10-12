package com.github.fabriciolfj.provider.repository.product;


import jooq.generated.tables.records.ProductRecord;

import java.util.Optional;

public interface ProductJooqRepository {

    Optional<ProductRecord> findByName(final String name);

    void addAllCategoriesToProduct(final Long productId);
}
