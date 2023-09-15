package com.leeonscoding.inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@AllArgsConstructor
@Getter
@Setter
public class AuditUser {
    String name;

    //Collection<? extends GrantedAuthority> authorities;
}
