package com.leeonscoding.inventory.api;

import com.leeonscoding.inventory.product.Product;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record AddSaleORPurchaseInput(@NotNull LocalDateTime createdDateTime,
                                     double tax,
                                     double discount,
                                     double paidAmount,
                                     @NotNull long contactId,
                                     @NotNull List<Long> productIdList) {
}
