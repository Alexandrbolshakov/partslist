package com.example.sells.repos;

import com.example.sells.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {

    Supplier findByName(String name);
}
