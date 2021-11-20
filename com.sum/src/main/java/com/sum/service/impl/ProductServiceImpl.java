package com.sum.service.impl;

import com.sum.pojo.Product;
import com.sum.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"A",50));
        products.add(new Product(2,"B",100));
        products.add(new Product(3,"C",150));
        return products;
    }
}
