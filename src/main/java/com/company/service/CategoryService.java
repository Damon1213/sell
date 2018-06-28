package com.company.service;

import com.company.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by hu on 2018-06-27.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategorytypeIn(List<Integer> categorytypeList);

    ProductCategory save(ProductCategory productCategory);
}
