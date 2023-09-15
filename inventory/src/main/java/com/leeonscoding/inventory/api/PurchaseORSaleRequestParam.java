package com.leeonscoding.inventory.api;

import java.time.LocalDateTime;

public record PurchaseORSaleRequestParam(LocalDateTime from,
                                         LocalDateTime to) {
}
