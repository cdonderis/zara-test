package com.cdonderis.zaratest.repository;

import com.cdonderis.zaratest.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
