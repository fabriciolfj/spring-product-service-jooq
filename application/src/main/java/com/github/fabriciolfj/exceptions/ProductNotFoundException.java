package com.github.fabriciolfj.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super(Errors.PRODUCT_NOT_FOUND.toMessage());
    }
}
