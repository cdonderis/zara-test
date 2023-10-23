package com.cdonderis.zaratest.service;

import com.cdonderis.zaratest.entity.Price;
import com.cdonderis.zaratest.entity.dto.PriceDTO;
import com.cdonderis.zaratest.repository.PriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceServiceImpl implements PriceService {

    private final Logger log = LoggerFactory.getLogger(PriceServiceImpl.class);

    @Autowired
    PriceRepository priceRepository;

    /**
     * Recupera un listado con todos los precios registrados
     *
     * @return List<PriceDTO>
     */
    public List<PriceDTO> findAll() {
        try {
            return priceRepository.findAll().stream().map(this::mapParameter).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error al intentar recuperar todos los precios registrados", e);
            return null;

        }

    }

    public List<PriceDTO> findByFilter(LocalDateTime fechaDeEntrada, int productId, Long brandId) {
        try {
            return priceRepository.findByFilter(fechaDeEntrada, productId, brandId)
                    .stream()
                    .map(this::mapParameter)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error("Error al recuperar precio con el filtro introducido", e);
            return null;
        }
    }


    /**
     * Mapea la entidad para devolver un objeto con los parámetros
     * que se desean mostrar.
     *
     * @param price-> Objeto Price completo
     * @return PriceDTO
     */
    private PriceDTO mapParameter(Price price) {

        PriceDTO mapPrice = new PriceDTO();

        mapPrice.setProductId(price.getProductId());
        mapPrice.setBrand(price.getBrand().getBrandId());
        mapPrice.setPriceList(price.getPriceList());
        mapPrice.setStartDate(price.getStartDate());
        mapPrice.setEndDate(price.getEndDate());
        mapPrice.setPrice(price.getPrice());

        return mapPrice;

    }
}
