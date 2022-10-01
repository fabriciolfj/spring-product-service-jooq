package com.github.fabriciolfj.exceptions;

import com.github.fabriciolfj.provider.repository.category.CategoryDataRepository;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super(Errors.CATEGORY_NOT_FOUND.toMessage());
    }
}
