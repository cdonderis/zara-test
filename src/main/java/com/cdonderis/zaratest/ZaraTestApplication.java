package com.cdonderis.zaratest;

import com.cdonderis.zaratest.repository.PriceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ZaraTestApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ZaraTestApplication.class, args);

		PriceRepository priceRepository = context.getBean(PriceRepository.class);

		System.out.println("Precios registrados: " + priceRepository.findAll().size() + "\n" + priceRepository.findAll());
	}
}
