package com.company.service.impl;

import com.company.dto.OrderDTO;
import com.company.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 订单
 * Created by hu on 2018-06-28.
 */
@Service
public class OrderServiceImpl implements OrderService {



    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //1.查询商品（数量，价格）
        
        //2.计算总价

        //3.写入订单数据库（orderMaster 和 orderDetail）

        //4.库存减少

        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
