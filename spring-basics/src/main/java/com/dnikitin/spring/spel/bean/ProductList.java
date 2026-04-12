package com.dnikitin.spring.spel.bean;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductList {
    private final List<Product> productList = new ArrayList<>(){{
        add(new Product(10, "Bread", true));
        add(new Product(1, "Meat", true));
        add(new Product(4, "Milk", false));
        add(new Product(8, "Tomato", true));
        add(new Product(3, "Sweet", false));
    }};

    public List<ProductList.Product> getProductList() {
        return productList;
    }

    static class Product{
        private final int count;
        private final String type;
        private final boolean isFit;

        public Product(int count, String type, boolean isFit) {
            this.count = count;
            this.type = type;
            this.isFit = isFit;
        }

        public int getCount() {
            return count;
        }

        public String getType() {
            return type;
        }

        public boolean getFit() {
            return isFit;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "count=" + count +
                    ", type='" + type + '\'' +
                    ", isFit=" + isFit +
                    '}';
        }
    }
}
