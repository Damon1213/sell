package com.company.repository;

import com.company.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品
 * Created by hu on 2018-06-27.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    /**
     * 根据商品状态查询商品
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
