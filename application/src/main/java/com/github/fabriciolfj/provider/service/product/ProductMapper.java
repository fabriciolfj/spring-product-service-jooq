package com.github.fabriciolfj.provider.service.product;

import com.github.fabriciolfj.domain.ProductEntity;
import com.github.fabriciolfj.entities.Category;
import com.github.fabriciolfj.entities.Product;

public class ProductMapper {

    private ProductMapper() { }

    public static ProductEntity toEntity(final Product product) {
        return new ProductEntity(product.getName(), product.getPrice());
    }

    public static Product toData(final ProductEntity entity) {
        var data = new Product();
        data.setId(null);
        data.setName(entity.describe());
        data.setPrice(entity.price());

        return data;
    }

    public static Product toData(final ProductEntity entity, final Category category) {
        var data = new Product();
        data.setId(null);
        data.setCategory(category);
        data.setName(entity.describe());
        data.setPrice(entity.price());

        return data;
    }
}
