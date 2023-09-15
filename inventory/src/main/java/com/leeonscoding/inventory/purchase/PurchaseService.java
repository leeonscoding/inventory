package com.leeonscoding.inventory.purchase;

import com.leeonscoding.inventory.api.AddSaleORPurchaseInput;
import com.leeonscoding.inventory.api.ApiException;
import com.leeonscoding.inventory.api.PurchaseORSaleRequestParam;

import java.util.List;

public interface PurchaseService {
    long addPurchase(AddSaleORPurchaseInput input) throws ApiException;

    void editPurchase(long id, AddSaleORPurchaseInput addPurchaseInput)  throws ApiException;

    void deletePurchase(long id)  throws ApiException;

    Purchase getOne(long id) throws ApiException;

    List<Purchase> list(PurchaseORSaleRequestParam param)  throws ApiException;
}
