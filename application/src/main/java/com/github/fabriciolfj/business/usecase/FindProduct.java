package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindByProductProvider;
import com.github.fabriciolfj.domain.ProductEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindProduct {

    private final FindByProductProvider provider;

    @Transactional(readOnly = true)
    public ProductEntity execute(final String name) {
        log.info("Find product: {}", name);
        return provider.process(name);
    }
}
