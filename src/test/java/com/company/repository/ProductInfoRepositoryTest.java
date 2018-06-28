package com.company.repository;

import com.company.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hu on 2018-06-27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findOne() {
        ProductInfo result = repository.findOne(1 + "");
        System.out.println(result.toString());
    }

    @Test
    @Transactional
    @Rollback(false)
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12345567678");
        productInfo.setProductName("九阳高压锅");
        productInfo.setProductPrice(new BigDecimal(299));
        productInfo.setProductStock(999);
        productInfo.setProductDescription("放心省事");
        productInfo.setProductIcon("http://www.baidu.com");
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(61);
        ProductInfo result = repository.save(productInfo);
        System.out.println(result.toString());
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = repository.findByProductStatus(1);
        Assert.assertNotEquals(0, list.size());
    }


}