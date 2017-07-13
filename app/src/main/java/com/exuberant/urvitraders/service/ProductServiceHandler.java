package com.exuberant.urvitraders.service;

import com.exuberant.urvitraders.model.Product;

import java.util.Collection;

public class ProductServiceHandler {

    private CachedProductService cachedProductService = new CachedProductService();
    private HTTPPProductService httppProductService = new HTTPPProductService();

    public Collection<Product> fetchProducts() {
        return cachedProductService.fetchProducts();
    }
}
