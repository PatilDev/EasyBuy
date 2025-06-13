package com.dev.modelviewcontroller.repository;

import com.dev.modelviewcontroller.Entity.Product;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class ProductRepositoryTest {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void findByProductType() {
		String productType = "abc";
		List<Product> expected = new ArrayList<>();
		List<Product> actual = productRepository.findByProductType(productType);

		assertEquals(expected, actual);
	}
}
