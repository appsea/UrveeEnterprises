package com.exuberant.urveeenterprises.service;


import com.exuberant.urveeenterprises.model.MetaProduct;

import java.util.Collection;

public interface ProductService {
    Collection<MetaProduct> fetchMetaProducts();
}
