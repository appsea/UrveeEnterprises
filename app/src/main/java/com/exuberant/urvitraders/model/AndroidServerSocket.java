package com.exuberant.urveeenterprises.model;

import com.exuberant.urveeenterprises.service.ProductServiceHandler;

import java.util.Collection;

public class AndroidServerSocket implements ServerSocket {

    private ProductServiceHandler productServiceHandler = new ProductServiceHandler();

    @Override
    public Collection<MetaProduct> fetchProducts() {
        return productServiceHandler.fetchProducts();
    }
}
