package com.exuberant.urveeenterprises.model;

import java.util.Collection;
import java.util.HashSet;

public class Product {

    private String name;
    private Collection<Quantity> quantities = new HashSet<>();

    public Product(String name, Collection<Quantity> quantities) {
        this.name = name;
        this.quantities = quantities;
    }

    private void addQuantity(String quantity, String unit){
        quantities.add(new Quantity(quantity, unit));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantities(Collection<Quantity> quantities) {
        this.quantities = quantities;
    }

    public Collection<Quantity> getQuantities() {
        return quantities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        return quantities != null ? quantities.containsAll(product.quantities) : product.quantities == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (quantities != null ? quantities.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product: " + name + " " + quantities;
    }
}
