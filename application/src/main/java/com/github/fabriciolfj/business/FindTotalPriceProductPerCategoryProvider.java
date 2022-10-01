package com.github.fabriciolfj.business;

import com.github.fabriciolfj.domain.CategoryPriceSummaryEntity;

public interface FindTotalPriceProductPerCategoryProvider {

    CategoryPriceSummaryEntity process(final String category);
}
