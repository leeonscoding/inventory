package com.leeonscoding.inventory.product;

import com.leeonscoding.inventory.api.AddProductInput;
import com.leeonscoding.inventory.api.ApiException;
import com.leeonscoding.inventory.api.ContactListRequestParam;

import java.util.List;

public interface ProductService {
    long addProduct(AddProductInput addProductInput) throws ApiException;

    void editProduct(AddProductInput addProductInput, long id) throws ApiException;

    void deleteProduct(long id) throws ApiException;

    Product getOne(long id) throws ApiException;

    List<Product> list(ContactListRequestParam param) throws ApiException;
}
