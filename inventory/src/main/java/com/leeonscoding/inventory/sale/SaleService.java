package com.leeonscoding.inventory.sale;

import com.leeonscoding.inventory.api.AddSaleORPurchaseInput;
import com.leeonscoding.inventory.api.ApiException;
import com.leeonscoding.inventory.api.PurchaseORSaleRequestParam;

import java.util.List;

public interface SaleService {
    long addSale(AddSaleORPurchaseInput addSaleORPurchaseInput) throws ApiException;

    void editSale(long id, AddSaleORPurchaseInput addSaleORPurchaseInput)  throws ApiException;

    void deleteSale(long id)  throws ApiException;

    Sale getOne(long id) throws ApiException;

    List<Sale> list(PurchaseORSaleRequestParam param)  throws ApiException;
}
