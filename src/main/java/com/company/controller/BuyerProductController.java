package com.company.controller;

import com.company.VO.ProductInfoVO;
import com.company.VO.ProductVO;
import com.company.VO.ResultVO;
import com.company.dataobject.ProductCategory;
import com.company.dataobject.ProductInfo;
import com.company.service.CategoryService;
import com.company.service.ProductService;
import com.company.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hu on 2018-06-28.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
    public ResultVO list() {
        //查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //查询类目（一次查询）
        /*List<ProductCategory> categoryList = categoryService.findAll();*/
        //精简方法（java8, lambda）
        List<Integer> productCategoryList = productInfoList.stream()
                .map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategorytypeIn(productCategoryList);

        //数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory category : categoryList) {
            //商品数据拼接
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            //商品详情拼接
            for (ProductInfo productInfo : productInfoList) {
                //如果商品详情中的类目和类目中的type一致
                if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //实体类属性复制(属性名必须一致)
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        /*resultVO.setData(productVOList);*/
        ResultVO resultVO = ResultVOUtil.success(productVOList);
        return resultVO;
    }

}
