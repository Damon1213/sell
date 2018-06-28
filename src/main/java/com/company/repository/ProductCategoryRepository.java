package com.company.repository;

import com.company.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hu on 2018-06-27.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    /**
     * 根据类目编号查找类目
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
