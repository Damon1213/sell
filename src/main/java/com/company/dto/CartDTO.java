package com.company.dto;

import lombok.Data;

/**
 * Created by HuDongDong on 2018/11/29.
 */
@Data
public class CartDTO {

    /** 商品Id */
    private String productId;

    /** 数量 */
    private Integer  productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
