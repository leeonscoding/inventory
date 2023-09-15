package com.leeonscoding.inventory.contact;

import com.leeonscoding.inventory.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(name = "fn_name", columnList = "name"),
        @Index(name = "fn_phone", columnList = "phone"),
        @Index(name = "fn_email", columnList = "email")
})
public class Contact extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private ContactType contactType;

    @OneToOne(
            mappedBy = "contact",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Address address;

    public void addAddress(Address address) {
        address.setContact(this);
        this.address = address;
    }

    public void removeAddress() {
        if(address != null) {
            address.setContact(null);
            address = null;
        }
    }
}
