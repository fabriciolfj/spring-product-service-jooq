package com.github.fabriciolfj.provider.repository.category.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorySumPriceProductPojo {

    private String describe;
    private BigDecimal price;
}
