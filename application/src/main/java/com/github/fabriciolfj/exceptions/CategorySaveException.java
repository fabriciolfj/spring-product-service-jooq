package com.github.fabriciolfj.exceptions;

public class CategorySaveException extends RuntimeException {

    public CategorySaveException() {
        super(Errors.CATEGORY_SAVE.toMessage());
    }
}
