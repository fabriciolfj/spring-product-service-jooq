package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.SaveProductProvider;
import com.github.fabriciolfj.domain.ProductEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveProduct {

    private final SaveProductProvider provider;

    @Transactional(propagation = Propagation.REQUIRED)
    public void execute(final ProductEntity product, final String category) {
        log.info("Save product {}", product.toString());
        provider.process(product, category);
    }
}
