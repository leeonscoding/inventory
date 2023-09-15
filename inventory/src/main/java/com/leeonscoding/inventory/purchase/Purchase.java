package com.leeonscoding.inventory.purchase;

import com.leeonscoding.inventory.contact.Contact;
import com.leeonscoding.inventory.domain.BaseSaleORPurchaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Purchase extends BaseSaleORPurchaseEntity {
    @ManyToOne
    @JoinColumn(name = "supplier_id",
            foreignKey = @ForeignKey(name = "FK_SUPPLIER_ID"))
    private Contact supplier;
}
