package com.leeonscoding.inventory.api;

import com.leeonscoding.inventory.product.Product;

import java.util.List;

public record ProductsOutput(List<Product> products) {
}
