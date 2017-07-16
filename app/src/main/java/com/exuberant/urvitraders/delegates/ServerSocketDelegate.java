package com.exuberant.urveeenterprises.delegates;

import com.exuberant.urveeenterprises.model.AndroidServerSocket;
import com.exuberant.urveeenterprises.model.MetaProduct;
import com.exuberant.urveeenterprises.model.Product;
import com.exuberant.urveeenterprises.model.ServerSocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by rakesh on 09-Jul-2017.
 */

public class ServerSocketDelegate {

    private ServerSocket serverSocket = new AndroidServerSocket();

    private Collection<MetaProduct> products;

    public ServerSocketDelegate() {
        this.products = serverSocket.fetchProducts();
    }

    public List<String> getProductNames() {
        List<String> productNames = new ArrayList<>();
        for (MetaProduct product : products) {
            productNames.add(product.getName());
        }
        return productNames;
    }
}
