package com.cdonderis.zaratest.resource;

import com.cdonderis.zaratest.entity.dto.PriceDTO;
import com.cdonderis.zaratest.service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceResource {

    //Inicialización del log
    private final Logger log = LoggerFactory.getLogger(PriceResource.class);

    @Autowired
    PriceService priceService;

    @GetMapping("/allPrices")
    public ResponseEntity<List<PriceDTO>> allPrices(){
        log.info("Buscando todos los precios existentes");
        List<PriceDTO> priceList = priceService.findAll();

        if(priceList == null){
            log.warn("Ningún precio encontrado");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(priceList);
    }

    @GetMapping("/filter/{fechaDeEntrada}/{productId}/{brandId}")
    public ResponseEntity<List<PriceDTO>> findByFilter(@PathVariable(value = "fechaDeEntrada") String fechaDeEntrada,
                                                       @PathVariable(value = "productId") int productId,
                                                       @PathVariable(value = "brandId") Long brandId) {
        log.info("\nFiltrando por: \nFecha de aplicacion: " + fechaDeEntrada + "\nIdentificador de producto: "
                + productId + "\nIdentificador de Cadena: " + brandId);

        //Formateo de fecha que se recibe desde la petición
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        LocalDateTime dataFormat = LocalDateTime.parse(fechaDeEntrada, format);
        List<PriceDTO> priceList = priceService.findByFilter(dataFormat, productId, brandId);
        if (priceList == null) {
            log.warn("No se ha encontrado ningún precio con esas características.");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(priceList);
    }
}