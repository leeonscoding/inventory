package com.leeonscoding.inventory.contact;

import org.springframework.data.jpa.domain.Specification;

public class ContactSpecifications {

    public static Specification<Contact> nameLike(String nameToken) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Contact_.NAME), nameToken+"%");
    }

    public static Specification<Contact> phoneLike(String phoneToken) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Contact_.PHONE), phoneToken+"%");
    }

    public static Specification<Contact> emailLike(String emailToken) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Contact_.EMAIL), emailToken+"%");
    }
}
