package com.exuberant.urveeenterprises.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rakesh on 16-Jul-2017.
 */
public class ProductTest {

    @Test
    public void testToString(){
        ProductBuilder productBuilder = new ProductBuilder();
        productBuilder.add("DHANA", "25", "KG");
        productBuilder.add("DHANA", "25", "KG");
        productBuilder.add("DHANA", "50", "KG");
        productBuilder.add("DHANA POWDER", "30", "KG");
        productBuilder.add("SPICY", "40", "KG");
        System.err.println("productBuilder.build(): " + productBuilder.build());
    }
}