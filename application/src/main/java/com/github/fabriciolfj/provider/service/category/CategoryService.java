package com.github.fabriciolfj.provider.service.category;

import com.github.fabriciolfj.business.FindTotalPriceProductPerCategoryProvider;
import com.github.fabriciolfj.business.FindTotalProductCategoryProvider;
import com.github.fabriciolfj.business.SaveCategoryProvider;
import com.github.fabriciolfj.domain.CategoryEntity;
import com.github.fabriciolfj.domain.CategoryPriceSummaryEntity;
import com.github.fabriciolfj.domain.CategoryQuantitySummaryEntity;
import com.github.fabriciolfj.entities.Category;
import com.github.fabriciolfj.exceptions.CategoryNotFoundException;
import com.github.fabriciolfj.exceptions.CategorySaveException;
import com.github.fabriciolfj.provider.repository.category.CategoryDataRepository;
import com.github.fabriciolfj.provider.repository.category.CategoryJooqRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class CategoryService implements FindTotalProductCategoryProvider, FindTotalPriceProductPerCategoryProvider, SaveCategoryProvider {

    private final CategoryJooqRespository categoryJooqRespository;
    private final CategoryDataRepository categoryDataRepository;

    public Category findByName(final String name) {
        return categoryDataRepository.findByName(name)
                .orElseThrow(() -> new CategoryNotFoundException());
    }

    @Override
    public CategoryPriceSummaryEntity process(final String category) {
        return categoryJooqRespository.sumPriceProduct(category)
                .map(CategoryMapper::toDomain)
                .orElseThrow(() -> new CategoryNotFoundException());
    }

    @Override
    public List<CategoryQuantitySummaryEntity> process() {
        return categoryJooqRespository.listSumProduct()
                .stream()
                .map(CategoryMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void process(final CategoryEntity category) {
        try {
            var record = CategoryMapper.toData(category.name());
            record.attach(categoryJooqRespository.getContext().configuration());

            var key = record.insert();
            log.info("key inserted category {}", key);
        } catch (Exception e) {
            log.error("Fail save category, details: {}", e.getMessage());
            throw new CategorySaveException();
        }
    }
}
