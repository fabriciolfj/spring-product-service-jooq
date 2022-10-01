package com.github.fabriciolfj.provider.service.product;

import com.github.fabriciolfj.business.FindByProductProvider;
import com.github.fabriciolfj.business.SaveProductProvider;
import com.github.fabriciolfj.domain.ProductEntity;
import com.github.fabriciolfj.exceptions.ProductNotFoundException;
import com.github.fabriciolfj.exceptions.ProductSaveException;
import com.github.fabriciolfj.provider.repository.product.ProductDataRepository;
import com.github.fabriciolfj.provider.repository.product.ProductJooqRepository;
import com.github.fabriciolfj.provider.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductService implements SaveProductProvider, FindByProductProvider {

    private final ProductJooqRepository jooqRepository;
    private final ProductDataRepository repository;
    private final CategoryService categoryService;

    @Override
    public ProductEntity process(final String name) {
        return jooqRepository.findByName(name)
                .map(r -> new ProductEntity(r.getName(), r.getPrice()))
                .orElseThrow(() -> new ProductNotFoundException());
    }

    @Override
    public void process(final ProductEntity productEntity, final String category) {
        try {
            var data = ProductMapper.toData(productEntity, categoryService.findByName(category));
            repository.save(data);
        } catch (Exception e) {
            log.error("Fail save product, details: {}", e.getMessage());
            throw new ProductSaveException();
        }
    }
}
