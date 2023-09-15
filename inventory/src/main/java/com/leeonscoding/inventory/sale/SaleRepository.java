package com.leeonscoding.inventory.sale;

import com.leeonscoding.inventory.purchase.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
