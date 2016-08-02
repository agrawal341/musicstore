package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.util.List;

/**
 * Created by Balram on 7/30/2016.
 */
public interface ProductDAO {

    void addProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    void deleteProduct(Long id);
    void editProduct(Product product);
}
