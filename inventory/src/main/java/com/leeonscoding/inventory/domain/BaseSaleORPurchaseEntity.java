package com.leeonscoding.inventory.domain;

import com.leeonscoding.inventory.product.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
public class BaseSaleORPurchaseEntity extends BaseEntity {
    LocalDateTime createdDateTime;

    private double subTotal;
    private double tax;
    private double discount;
    private double total;
    private double paidAmount;
    private double dueAmount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;
}
