package com.leeonscoding.inventory.purchase;

import com.leeonscoding.inventory.api.AddSaleORPurchaseInput;
import com.leeonscoding.inventory.api.ApiException;
import com.leeonscoding.inventory.api.PurchaseORSaleRequestParam;
import com.leeonscoding.inventory.product.Product;
import com.leeonscoding.inventory.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseRepository purchaseRepository;
    private ProductRepository productRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.productRepository = productRepository;
    }

    @Override
    public long addPurchase(AddSaleORPurchaseInput input) throws ApiException {
        List<Long> productIdList = input.productIdList();

        List<Product> productList = productIdList.stream()
                .map(id -> productRepository.findById(id).get())
                .toList();

        return 0;
    }

    @Override
    public void editPurchase(long id, AddSaleORPurchaseInput addPurchaseInput) throws ApiException {

    }

    @Override
    public void deletePurchase(long id) throws ApiException {

    }

    @Override
    public Purchase getOne(long id) throws ApiException {
        return null;
    }

    @Override
    public List<Purchase> list(PurchaseORSaleRequestParam param) throws ApiException {
        return null;
    }
}
