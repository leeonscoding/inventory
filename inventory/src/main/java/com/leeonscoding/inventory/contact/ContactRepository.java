package com.leeonscoding.inventory.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface ContactRepository extends JpaRepository<Contact, Long>,
                                            JpaSpecificationExecutor<Contact> {
}
