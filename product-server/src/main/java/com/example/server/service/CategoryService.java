package com.example.server.service;



import com.example.server.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 *
 */
public interface CategoryService {


    /**
     *  查询 type 类目列表
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
