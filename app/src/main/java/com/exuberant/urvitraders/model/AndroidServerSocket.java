package com.exuberant.urvitraders.model;

import com.exuberant.urvitraders.service.ProductServiceHandler;

import java.util.Collection;

public class AndroidServerSocket implements ServerSocket {

    private ProductServiceHandler productServiceHandler = new ProductServiceHandler();

    @Override
    public Collection<MetaProduct> fetchProducts() {
        return productServiceHandler.fetchProducts();
    }
}
