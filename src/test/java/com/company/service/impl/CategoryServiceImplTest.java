package com.company.service.impl;

import com.company.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hu on 2018-06-27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory category = categoryService.findOne(10);
        Assert.assertEquals(new Integer(10), category.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findByCategorytypeIn() throws Exception {
        List<Integer> list = Arrays.asList(121,6,61,611);
        List<ProductCategory> categoryList = categoryService.findByCategorytypeIn(list);
        Assert.assertNotEquals(0, categoryList.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("上海欢迎你");
        category.setCategoryType(9);
        ProductCategory result = categoryService.save(category);
        Assert.assertNotNull(result);
    }

}