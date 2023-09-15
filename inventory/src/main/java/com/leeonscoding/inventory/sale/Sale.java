package com.leeonscoding.inventory.sale;

import com.leeonscoding.inventory.contact.Contact;
import com.leeonscoding.inventory.domain.BaseSaleORPurchaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Sale extends BaseSaleORPurchaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id",
            foreignKey = @ForeignKey(name = "FK_CUSTOMER_ID"))
    private Contact customer;
}
