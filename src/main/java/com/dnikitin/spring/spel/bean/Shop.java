package com.dnikitin.spring.spel.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class Shop {

    @Value("#{productList.getProductList()}")
    private List<ProductList.Product> productList;

    //.? - not null
    @Value("#{productList.getProductList().?[getFit()]}")
    private List<ProductList.Product> suitableProductList;

    @Value("#{productList.getProductList().?[getCount() < 5]}")
    private List<ProductList.Product> endingProductList;

    @Value("#{productList.getProductList()[2]}")
    private ProductList.Product secondProduct;

    @Value("#{T(java.time.LocalTime).of(9, 0)}")
    private LocalTime openingTime;

    public void printAllProducts() {
        System.out.println("productList: " + productList);
    }

    public void printAllSuitableProducts() {
        System.out.println("suitableProductList: " + suitableProductList);
    }
    public void printAllEndingProducts() {
        System.out.println("endingProductList: " + endingProductList);
        System.out.println("secondProduct: " + secondProduct);
    }

    public void printOpeningTime() {
        System.out.println("openingTime: " + openingTime);
    }
}
