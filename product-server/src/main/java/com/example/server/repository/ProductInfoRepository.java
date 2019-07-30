package com.example.server.repository;



import com.example.server.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {


    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 通过 ID 列表 来 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);


}
