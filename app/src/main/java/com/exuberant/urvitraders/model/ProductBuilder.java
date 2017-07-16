package com.exuberant.urveeenterprises.model;

import com.exuberant.urveeenterprises.util.MultiValueMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ProductBuilder {

    private Collection<Product> products = new ArrayList<>();

    private MultiValueMap<String, Quantity> allProducts = new MultiValueMap();

    public void add(String name, String quantity, String unit) {
        allProducts.put(name, new Quantity(quantity, unit));
    }

    public Collection<Product> build(){
        for (Map.Entry<String, Set<Quantity>> entry : allProducts.entries()) {
            products.add(new Product(entry.getKey(), entry.getValue()));
        }
        return products;
    }


}
