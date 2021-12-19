package com.sum.service.impl;

import com.sum.client.ProductClientRibbon;
import com.sum.pojo.Product;
import com.sum.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductClientRibbon productClientRibbon;

    @Override
    public List<Product> listProducts() {
        return productClientRibbon.listProducts();
    }
}
