package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.SaveCategoryProvider;
import com.github.fabriciolfj.domain.CategoryEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveCategory {

    private final SaveCategoryProvider provider;

    @Transactional(propagation = Propagation.REQUIRED)
    public void execute(final CategoryEntity category) {
        log.info("Save category: {}", category);
        provider.process(category);
    }
}
