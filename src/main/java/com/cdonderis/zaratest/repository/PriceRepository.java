package com.cdonderis.zaratest.repository;

import com.cdonderis.zaratest.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
