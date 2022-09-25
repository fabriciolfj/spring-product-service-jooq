package com.github.fabriciolfj.provider.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorySumProductPojo {

    public String describe;
    private Long total;
}
