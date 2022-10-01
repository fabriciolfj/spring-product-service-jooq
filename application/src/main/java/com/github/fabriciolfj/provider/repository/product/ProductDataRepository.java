package com.github.fabriciolfj.provider.repository.product;

import com.github.fabriciolfj.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDataRepository extends JpaRepository<Product, Long> {
}
