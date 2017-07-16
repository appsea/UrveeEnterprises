package com.exuberant.urveeenterprises.service;

import com.exuberant.urveeenterprises.model.MetaProduct;
import com.exuberant.urveeenterprises.model.Product;

import java.util.Collection;

public class ProductServiceHandler {

    private CachedProductService cachedProductService = new CachedProductService();
    private HTTPPProductService httppProductService = new HTTPPProductService();

    public Collection<MetaProduct> fetchProducts() {
        return cachedProductService.fetchMetaProducts();
    }
}
