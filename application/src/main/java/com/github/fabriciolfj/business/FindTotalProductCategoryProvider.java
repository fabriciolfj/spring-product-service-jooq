package com.github.fabriciolfj.business;

import com.github.fabriciolfj.domain.CategoryQuantitySummaryEntity;

import java.util.List;

public interface FindTotalProductCategoryProvider {

    List<CategoryQuantitySummaryEntity> process();
}
