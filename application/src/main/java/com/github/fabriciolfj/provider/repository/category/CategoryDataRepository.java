package com.github.fabriciolfj.provider.repository.category;

import com.github.fabriciolfj.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryDataRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(final String name);
}
