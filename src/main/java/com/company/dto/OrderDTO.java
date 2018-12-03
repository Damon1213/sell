package com.company.dto;

import com.company.dataobject.OrderDetail;
import com.company.utils.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by hu on 2018-06-28.
 */
@Data
public class OrderDTO {
    private String orderId;

    /**买家名字. */
    private String buyerName;

    /**买家电话. */
    private String buyerPhone;

    /**买家地址. */
    private String buyerAddress;

    /**买家微信openid. */
    private String buyerOpenid;

    /**订单总金额. */
    private BigDecimal orderAmount;

    /**订单状态,默认0未下单. */
    private Integer orderStatus;

    /**支付状态,默认0未支付. */
    private Integer payStatus;

    /**创建时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**修改时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /** 订单详情list. */
    List<OrderDetail> orderDetailList;
}
