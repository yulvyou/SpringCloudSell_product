package com.example.server.controller;

import com.example.common.DecreaseStockInput;
import com.example.common.ProductInfoOutput;
import com.example.server.VO.ProductInfoVO;
import com.example.server.VO.ProductVO;
import com.example.server.VO.ResultVO;
import com.example.server.dataobject.ProductCategory;
import com.example.server.dataobject.ProductInfo;
import com.example.server.service.CategoryService;
import com.example.server.service.ProductService;
import com.example.server.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品 Controller
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    /**
     * 1、查询所有在架的商品
     * 2、获取类目 type 列表
     * 3、查询类目
     * 4、构造数据
     */

    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        //1、查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2、获取类目 type 列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3、从数据库查询类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //4、构造数据
        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);


    }


    /**
     * 获取商品列表（给订单服务调用的）
     * @param productIdList 商品ID列表
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList){

        return productService.findList(productIdList);
    }


    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList){
        productService.descreaseStock(decreaseStockInputList);
    }


}
