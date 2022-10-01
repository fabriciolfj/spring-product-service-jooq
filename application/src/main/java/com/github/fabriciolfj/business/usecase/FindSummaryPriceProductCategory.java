package com.github.fabriciolfj.business.usecase;


import com.github.fabriciolfj.business.FindTotalPriceProductPerCategoryProvider;
import com.github.fabriciolfj.domain.CategoryPriceSummaryEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class FindSummaryPriceProductCategory {

    private final FindTotalPriceProductPerCategoryProvider provider;

    @Transactional(readOnly = true)
    public CategoryPriceSummaryEntity execute(final String category) {
        log.info("Find sum price product by category: {}", category);
        return provider.process(category);
    }
}
