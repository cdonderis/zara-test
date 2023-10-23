package com.cdonderis.zaratest.repository;

import com.cdonderis.zaratest.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query(value = "SELECT p FROM Price p WHERE (p.startDate <= :fechaDeEntrada AND p.endDate >= :fechaDeEntrada )AND p.productId = :productId AND p.brand.brandId = :brandId")
    List<Price> findByFilter(LocalDateTime fechaDeEntrada, int productId, Long brandId);

}
