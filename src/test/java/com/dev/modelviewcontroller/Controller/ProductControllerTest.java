package com.dev.modelviewcontroller.Controller;

import com.dev.modelviewcontroller.Service.ProductService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@Test
	public void saveProduct() throws Exception {
		this.mockMvc.perform(post("/addProduct")
				.param("image", "<value>")
				.param("productAmount", "123")
				.param("productName", "abc")
				.param("productQuantity", "123")
				.param("productType", "abc"))
			.andExpect(status().isOk())
			.andExpect(view().name("abc"))
			.andExpect(content().string(""));
	}
}
