package com.company.service;

import com.company.dto.OrderDTO;

/**
 * Created by HuDongDong on 2018/12/3.
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
