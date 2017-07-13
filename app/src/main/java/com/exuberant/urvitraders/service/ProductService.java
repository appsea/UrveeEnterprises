package com.exuberant.urvitraders.service;


import com.exuberant.urvitraders.model.Product;

import java.util.Collection;

public interface ProductService {
    Collection<Product> fetchProducts();
}
