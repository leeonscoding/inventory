package com.leeonscoding.inventory.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByName(String name);
}
