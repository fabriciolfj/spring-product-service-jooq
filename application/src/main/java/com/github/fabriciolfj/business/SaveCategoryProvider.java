package com.github.fabriciolfj.business;

import com.github.fabriciolfj.domain.CategoryEntity;

public interface SaveCategoryProvider {

    void process(final CategoryEntity category);
}
