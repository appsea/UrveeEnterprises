package com.exuberant.urveeenterprises.service;

import com.exuberant.urveeenterprises.model.MetaProduct;
import com.exuberant.urveeenterprises.model.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

class CachedProductService implements ProductService {

    private Collection<MetaProduct> cachedMetaProducts = new ArrayList<>();

    public CachedProductService() {
        MetaProduct p1 = new MetaProduct("DHANA POWDER", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        MetaProduct p2 = new MetaProduct("CHANA MASALA", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        MetaProduct p3 = new MetaProduct("PANEER", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        MetaProduct p4 = new MetaProduct("CASHEW", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        MetaProduct p5 = new MetaProduct("OIL", Arrays.asList(Unit.MILI, Unit.LITER));
        MetaProduct p6 = new MetaProduct("GARAM MASALA", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        MetaProduct p7 = new MetaProduct("ALMONDS", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        MetaProduct p8 = new MetaProduct("EVEREST PAV BHAJI", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        MetaProduct p9 = new MetaProduct("EVEREST GARLIC", Arrays.asList(Unit.GRAMS, Unit.GRAMS));
        MetaProduct p10 = new MetaProduct("PALM OIL", Arrays.asList(Unit.MILI, Unit.LITER));

        this.cachedMetaProducts = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    @Override
    public Collection<MetaProduct> fetchMetaProducts() {
        return cachedMetaProducts;
    }
}
