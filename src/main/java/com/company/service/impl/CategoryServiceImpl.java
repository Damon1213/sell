package com.company.service.impl;

import com.company.dataobject.ProductCategory;
import com.company.repository.ProductCategoryRepository;
import com.company.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hu on 2018-06-27.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Override
    public ProductCategory findOne(Integer categoryId) {

        return categoryRepository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategorytypeIn(List<Integer> categorytypeList) {
        return categoryRepository.findByCategoryTypeIn(categorytypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return categoryRepository.save(productCategory);
    }
}
