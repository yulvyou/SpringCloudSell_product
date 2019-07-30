package com.example.server.service;


import com.example.common.DecreaseStockInput;
import com.example.common.ProductInfoOutput;
import com.example.server.dataobject.ProductInfo;

import java.util.List;

/**
 * 商品
 */
public interface ProductService {


    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList 商品列表
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);


    /**
     * 扣库存
     * @param decreaseStockInputList 购物车列表
     */
    void descreaseStock(List<DecreaseStockInput> decreaseStockInputList);

}
