package com.leeonscoding.inventory.purchase;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseRepository  extends JpaRepository<Purchase, Long> {

}
