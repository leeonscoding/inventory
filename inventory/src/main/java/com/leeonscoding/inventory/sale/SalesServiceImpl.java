package com.leeonscoding.inventory.sale;

import com.leeonscoding.inventory.api.AddSaleORPurchaseInput;
import com.leeonscoding.inventory.api.ApiException;
import com.leeonscoding.inventory.api.PurchaseORSaleRequestParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SaleService{

    private SaleRepository saleRepository;

    public SalesServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public long addSale(AddSaleORPurchaseInput addSaleORPurchaseInput) throws ApiException {
        return 0;
    }

    @Override
    public void editSale(long id, AddSaleORPurchaseInput addSaleORPurchaseInput) throws ApiException {

    }

    @Override
    public void deleteSale(long id) throws ApiException {

    }

    @Override
    public Sale getOne(long id) throws ApiException {
        return null;
    }

    @Override
    public List<Sale> list(PurchaseORSaleRequestParam param) throws ApiException {
        return null;
    }
}
