package com.leeonscoding.inventory.api;

import jakarta.validation.constraints.NotNull;

public record AddProductInput(@NotNull String name,
                              String description,
                              @NotNull double purchasePrice,
                              @NotNull double sellPrice,
                              @NotNull int stock) {
}
