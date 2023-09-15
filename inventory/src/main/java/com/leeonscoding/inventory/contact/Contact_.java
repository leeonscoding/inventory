package com.leeonscoding.inventory.contact;

import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Contact.class)
public abstract class Contact_ {
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";

}
