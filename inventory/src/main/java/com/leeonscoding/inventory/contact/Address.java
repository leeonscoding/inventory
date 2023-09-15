package com.leeonscoding.inventory.contact;

import com.leeonscoding.inventory.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Address extends BaseEntity {
    private String street;
    private String city;
    private String state;
    private String zip;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
