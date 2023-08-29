package com.example.ceo.repository;

import com.example.ceo.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository
        extends JpaRepository<Store, Long> {
}
