package com.leeonscoding.inventory.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record AddContactInput (@NotNull String name,
                               @Email @NotNull String email,
                               @NotNull String phone,
                               String city,
                               String state,
                               String street,
                               String zip) {

}
