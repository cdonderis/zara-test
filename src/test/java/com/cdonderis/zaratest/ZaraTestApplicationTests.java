package com.cdonderis.zaratest;

import com.cdonderis.zaratest.entity.dto.PriceDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceRepositoryTest {

	private TestRestTemplate testRestTemplate;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() {
		restTemplateBuilder = restTemplateBuilder.rootUri(("http://localhost:" + port));
		testRestTemplate = new TestRestTemplate(restTemplateBuilder);
	}

	@Test
	void findAll() {
		ResponseEntity<PriceDTO[]> response = testRestTemplate.getForEntity("/price/allPrices", PriceDTO[].class);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		List<PriceDTO> prices = Arrays.asList(response.getBody());
		System.out.println("Find all, lista: " + prices);
	}

	@Test
	void findByFilter() {
		System.out.println("Ejecutando test 1: ");
		ResponseEntity<PriceDTO[]> test1 = testRestTemplate.getForEntity("/price/filter/2020-06-14-10:00:00/35455/1", PriceDTO[].class);
		Assertions.assertEquals(HttpStatus.OK, test1.getStatusCode());
		List<PriceDTO> preciosTest1 = Arrays.asList(test1.getBody());
		Assertions.assertEquals(preciosTest1.size(), 1);
		Assertions.assertEquals(preciosTest1.get(0).getPriceList(), 1);

		System.out.println("\nEjecutando test 2: ");
		ResponseEntity<PriceDTO[]> test2 = testRestTemplate.getForEntity("/price/filter/2020-06-14-16:00:00/35455/1", PriceDTO[].class);
		Assertions.assertEquals(HttpStatus.OK, test2.getStatusCode());
		List<PriceDTO> preciosTest2 = Arrays.asList(test2.getBody());
		Assertions.assertEquals(preciosTest2.size(), 2);

		System.out.println("\nEjecutando test 3: ");
		ResponseEntity<PriceDTO[]> test3 = testRestTemplate.getForEntity("/price/filter/2020-06-14-21:00:00/35455/1", PriceDTO[].class);
		Assertions.assertEquals(HttpStatus.OK, test3.getStatusCode());
		List<PriceDTO> preciosTest3 = Arrays.asList(test3.getBody());
		Assertions.assertEquals(preciosTest3.size(), 1);
		Assertions.assertEquals(preciosTest1.get(0).getPriceList(), 1,"Test 3");

		System.out.println("\nEjecutando test 4: ");
		ResponseEntity<PriceDTO[]> test4 = testRestTemplate.getForEntity("/price/filter/2020-06-15-10:00:00/35455/1", PriceDTO[].class);
		List<PriceDTO> precioTest4 = Arrays.asList(test4.getBody());
		Assertions.assertEquals(HttpStatus.OK, test1.getStatusCode());
		List<PriceDTO> preciosTest4 = Arrays.asList(test4.getBody());
		Assertions.assertEquals(preciosTest4.size(), 2);

		System.out.println("\nEjecutando test 5: ");
		ResponseEntity<PriceDTO[]> test5 = testRestTemplate.getForEntity("/price/filter/2020-06-16-21:00:00/35455/1", PriceDTO[].class);
		List<PriceDTO> precioTest5 = Arrays.asList(test5.getBody());
		Assertions.assertEquals(HttpStatus.OK, test5.getStatusCode());
		List<PriceDTO> preciosTest5 = Arrays.asList(test5.getBody());
		Assertions.assertEquals(preciosTest5.size(), 2);
	}


}
