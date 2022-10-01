package com.github.fabriciolfj.business;

import com.github.fabriciolfj.domain.ProductEntity;

public interface SaveProductProvider {

    void process(final ProductEntity productEntity, final String category);
}
