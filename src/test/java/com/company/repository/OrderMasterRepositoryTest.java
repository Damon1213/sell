package com.company.repository;

import com.company.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by hu on 2018-06-28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("765432100");
        orderMaster.setBuyerName("刘德华");
        orderMaster.setBuyerPhone("18817667776");
        orderMaster.setBuyerAddress("上海陆家嘴环球金融中心58楼");
        orderMaster.setBuyerOpenid("wx1111222");
        orderMaster.setOrderAmount(new BigDecimal(999.9));
        OrderMaster result = repository.save(orderMaster);

        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest pageRequest = new PageRequest(1,3);

        Page<OrderMaster> result = repository.findByBuyerOpenid("wx1111222", pageRequest);

        int size = result.getContent().size();
        System.out.println("size::" + size);

        System.out.println(result.getTotalElements());
    }

}