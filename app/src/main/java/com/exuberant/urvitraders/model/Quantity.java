package com.exuberant.urveeenterprises.model;

import java.util.Objects;

/**
 * Created by rakesh on 16-Jul-2017.
 */

class Quantity {

    private String quantity;
    private String unit;

    public Quantity(String quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quantity quantity1 = (Quantity) o;

        if (quantity != null ? !quantity.equals(quantity1.quantity) : quantity1.quantity != null)
            return false;
        return unit != null ? unit.equals(quantity1.unit) : quantity1.unit == null;

    }

    @Override
    public int hashCode() {
        int result = quantity != null ? quantity.hashCode() : 0;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return quantity + unit;
    }
}
