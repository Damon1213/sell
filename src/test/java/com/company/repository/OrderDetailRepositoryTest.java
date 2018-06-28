package com.company.repository;

import com.company.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hu on 2018-06-28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("98989899010");
        orderDetail.setOrderId("765432100");
        orderDetail.setProductId("12345567678");
        orderDetail.setProductName("九阳高压锅");
        orderDetail.setProductPrice(new BigDecimal(299));
        orderDetail.setProductQuantity(1);
        orderDetail.setProductIcon("http://www.baidu.com");
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> list = repository.findByOrderId("765432100");
        Assert.assertNotEquals(0, list.size());
    }

}