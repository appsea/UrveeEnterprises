package com.exuberant.urvitraders.model;

import java.util.Collection;

public class MetaProduct {

    private String name;
    private Collection<Unit> unit;

    public MetaProduct(String name, Collection<Unit> unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Unit> getUnit() {
        return unit;
    }

    public void setUnit(Collection<Unit> unit) {
        this.unit = unit;
    }
}

