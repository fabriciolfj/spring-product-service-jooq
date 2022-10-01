package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindTotalProductCategoryProvider;
import com.github.fabriciolfj.domain.CategoryQuantitySummaryEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindSummaryCountProductCategory {

    private FindTotalProductCategoryProvider provider;

    public List<CategoryQuantitySummaryEntity> execute() {
        var result = provider.process();
        log.info("Result summary {}", result.size());

        return result;
    }
}
