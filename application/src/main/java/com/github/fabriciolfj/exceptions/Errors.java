package com.github.fabriciolfj.exceptions;

import java.util.ResourceBundle;

public enum Errors {

    PRODUCT_NOT_FOUND,
    PRODUCT_SAVE,
    CATEGORY_SAVE,
    CATEGORY_NOT_FOUND;

    public String toMessage() {
        var resource = ResourceBundle.getBundle("messages/exceptions");
        return resource.getString(this.name() + ".message");
    }
}
