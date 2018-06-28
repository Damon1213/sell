package com.company.service.impl;

import com.company.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hu on 2018-06-27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productService.findOne("12345567678");
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findAll() throws Exception {
        /*分页*/
        PageRequest pageRequest = new PageRequest(0,5);
        Page<ProductInfo> page = productService.findAll(pageRequest);
        System.out.println(page.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("354345678981");
        productInfo.setProductName("小米手机");
        productInfo.setProductPrice(new BigDecimal(2699));
        productInfo.setProductStock(100000);
        productInfo.setProductDescription("好用就是贵");
        productInfo.setProductIcon("http://www.baidu.com");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(112);
        ProductInfo result = productService.save(productInfo);
        System.out.println(result.toString());
    }

}