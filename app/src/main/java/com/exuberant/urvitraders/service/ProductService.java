package com.exuberant.urvitraders.service;


import com.exuberant.urvitraders.model.MetaProduct;

import java.util.Collection;

public interface ProductService {
    Collection<MetaProduct> fetchMetaProducts();
}
