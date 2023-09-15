package com.leeonscoding.inventory.product;

import com.leeonscoding.inventory.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(indexes = @Index(name = "fn_product_name", columnList = "name"))
public class Product extends BaseEntity {
    @NotNull
    private String name;
    private String description;
    @NotNull
    private double purchasePrice;
    @NotNull
    private double sellPrice;
    @NotNull
    private int stock;
}
