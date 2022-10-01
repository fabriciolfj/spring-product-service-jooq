package com.github.fabriciolfj.exceptions;

public class ProductSaveException extends RuntimeException {

    public ProductSaveException() {
        super(Errors.PRODUCT_SAVE.toMessage());
    }
}
