package com.example.sells.repos;

import com.example.sells.domain.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartRepo extends CrudRepository<Part, Long> {
    Page findAll(Pageable pageable);
    Page<Part> findByPartNumber(String number, Pageable pageable);
}
