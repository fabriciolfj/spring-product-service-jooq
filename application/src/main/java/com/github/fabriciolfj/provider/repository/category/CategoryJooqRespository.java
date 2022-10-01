package com.github.fabriciolfj.provider.repository.category;

import com.github.fabriciolfj.provider.repository.category.pojo.CategorySumPriceProductPojo;
import com.github.fabriciolfj.provider.repository.category.pojo.CategorySumProductPojo;

import java.util.List;
import java.util.Optional;

public interface CategoryJooqRespository {

    List<CategorySumProductPojo> listSumProduct();

    Optional<CategorySumPriceProductPojo> sumPriceProduct(final String name);
}
