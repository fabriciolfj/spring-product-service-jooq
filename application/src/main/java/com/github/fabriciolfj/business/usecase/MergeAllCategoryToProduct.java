package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.AddAllCategoryToProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MergeAllCategoryToProduct {

    private final AddAllCategoryToProduct provider;

    public void execute(final Long productId) {
        provider.process(productId);
    }
}
