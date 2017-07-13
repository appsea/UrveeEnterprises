package com.exuberant.urvitraders.service;

import com.exuberant.urvitraders.model.Product;
import com.exuberant.urvitraders.model.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

class CachedProductService implements ProductService {


    private Collection<Product> cachedProducts = new ArrayList<>();

    public CachedProductService() {
        Product p1 = new Product("DHANA POWDER", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        Product p2 = new Product("CHANA MASALA", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        Product p3 = new Product("PANEER", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        Product p4 = new Product("CASHEW", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        Product p5 = new Product("OIL", Arrays.asList(Unit.MILI, Unit.LITER));
        Product p6 = new Product("GARAM MASALA", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        Product p7 = new Product("ALMONDS", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        Product p8 = new Product("EVEREST PAV BHAJI", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        Product p9 = new Product("EVEREST GARLIC", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        Product p10 = new Product("PALM OIL", Arrays.asList(Unit.MILI, Unit.LITER));

        this.cachedProducts = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    @Override
    public Collection<Product> fetchProducts() {
        return cachedProducts;
    }
}
