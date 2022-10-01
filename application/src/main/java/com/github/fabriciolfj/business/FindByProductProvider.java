package com.github.fabriciolfj.business;

import com.github.fabriciolfj.domain.ProductEntity;

public interface FindByProductProvider {

    ProductEntity process(final String name);
}
