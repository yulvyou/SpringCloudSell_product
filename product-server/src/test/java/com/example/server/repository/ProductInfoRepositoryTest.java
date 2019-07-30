package com.example.server.repository;

import com.example.server.dataobject.ProductInfo;
import org.hibernate.validator.constraints.EAN;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {



    }

    @Test
    public void a() {

        List<String> list = new ArrayList<String>();
        list.add("157875196366160022");

        List<ProductInfo> result = productInfoRepository.findByProductIdIn(list);

        int q =1;
//        Assert.assertTrue(result.size()>0);
    }
}