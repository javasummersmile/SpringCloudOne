package com.sum.service.impl;

import com.sum.client.ProductClientFeign;
import com.sum.pojo.Product;
import com.sum.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductClientFeign productClientFeign;
    public List<Product> listProducts(){
        List<Product> list = productClientFeign.listProducts();

        return list;
    }
}
