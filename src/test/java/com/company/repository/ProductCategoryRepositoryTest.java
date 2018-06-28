package com.company.repository;

import com.company.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hu on 2018-06-27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Test
    @Transactional
    public void findOneTest() {
        ProductCategory category = categoryRepository.getOne(1);
        System.out.println(category.toString());
    }

    @Test
    @Transactional
    @Rollback(false) //关闭自动回滚
    public void saveTest() {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("快乐3");
        category.setCategoryType(64);
        ProductCategory save = categoryRepository.save(category);
        Assert.assertNotNull(save);
        System.out.println(save.toString());
    }

    @Test
    @Transactional
    @Rollback(false) //关闭自动回滚
    public void updateTest() {
        ProductCategory category = categoryRepository.getOne(8);
        category.setCategoryName("快乐女声");
        category.setCategoryType(121);
        ProductCategory save = categoryRepository.save(category);
        Assert.assertNull(save);
        System.out.println(save.toString());
    }

    @Test
    @Transactional
    @Rollback(false) //关闭自动回滚
    public void findTypeTest() {
        List<Integer> list = Arrays.asList(6,61);

        List<ProductCategory> categoryTypeIn = categoryRepository.findByCategoryTypeIn(list);
        //不为0
        Assert.assertNotEquals(0, categoryTypeIn.size());
    }

}