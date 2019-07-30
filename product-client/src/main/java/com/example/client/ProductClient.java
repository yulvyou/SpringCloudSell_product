package com.example.client;

import com.example.common.DecreaseStockInput;
import com.example.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

/**
 * 定义 Feign 需要调用 product 服务的哪些接口
 */
@FeignClient(name = "product")  //对应服务
public interface ProductClient {

    /**
     * 服务中对应的接口（PS：只要接口的地址和服务的接口地址一致就行，方法可以不一样）
     * @return
     */
    @GetMapping("/msg")
    String productMsg();


    /**
     * @param productIdList
     * @return
     */
    @PostMapping("/product/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);


    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> cartDTOList);

}
