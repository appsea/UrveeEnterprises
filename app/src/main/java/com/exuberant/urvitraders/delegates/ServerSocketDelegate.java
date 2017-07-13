package com.exuberant.urvitraders.delegates;

import com.exuberant.urvitraders.model.AndroidServerSocket;
import com.exuberant.urvitraders.model.Product;
import com.exuberant.urvitraders.model.ServerSocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by rakesh on 09-Jul-2017.
 */

public class ServerSocketDelegate {

    private ServerSocket serverSocket = new AndroidServerSocket();

    private Collection<Product> products;

    public ServerSocketDelegate() {
        this.products = serverSocket.fetchProducts();
    }

    public List<String> getProductNames() {
        List<String> productNames = new ArrayList<>();
        for (Product product : products) {
            productNames.add(product.getName());
        }
        return productNames;
    }
}
