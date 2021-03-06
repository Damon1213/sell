package com.company.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品信息
 * Created by hu on 2018-06-27.
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /*商品名称*/
    private String productName;

    /*商品价格*/
    private BigDecimal productPrice;

    /*商品库存*/
    private Integer productStock;

    /*商品描述*/
    private String productDescription;

    /*商品图片url*/
    private String productIcon;

    /*商品状态,0正常1下架*/
    private Integer productStatus;

    /*商品类目编号*/
    private Integer categoryType;

}
