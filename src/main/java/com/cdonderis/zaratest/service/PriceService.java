package com.cdonderis.zaratest.service;

import com.cdonderis.zaratest.entity.dto.PriceDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {
    public List<PriceDTO> findAll();

    public List<PriceDTO> findByFilter(LocalDateTime fechaDeEntrada, int productId, Long brandId);
}
