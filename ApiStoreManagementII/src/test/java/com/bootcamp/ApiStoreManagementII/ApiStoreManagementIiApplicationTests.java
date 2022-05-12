package com.bootcamp.ApiStoreManagementII;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bootcamp.ApiStoreManagementII.Controllers.ProductsController;
import com.bootcamp.ApiStoreManagementII.Model.Products;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import junit.framework.Assert;



@RunWith(SpringRunner.class)
@SpringBootTest
class ApiStoreManagementIiApplicationTests {

	@Autowired
	private ProductsController controllerProducts;
	
	@Autowired
	private WebApplicationContext aplicationContext;
	
	private MockMvc mock;
	
	/*@org.junit.Before
	public void setup() {
		
	}*/
	
	@Test
	void SAVE_PRODUCT() throws Exception {
		/*Products product = new Products();
		product.setName("Apple");
		product.setPrice(7.65);
		product.setCode(4365);
		product.setStock(7);*/
		mock = MockMvcBuilders.webAppContextSetup(aplicationContext).build();
		String product = "{\"name\":\"Green Apple \",\"price\":5.5,\"stock\":\"7 \",\"code\":4678 }";
		String JsonResponse = mock.perform(post("/api/products")
				.content(product)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.TEXT_PLAIN))
				.andExpect(
					status()
					.isCreated())
				.andReturn()
				.getResponse()
				.getContentAsString();
		System.out.println(JsonResponse);
	}
	
	
	@Test
	public void SELECT_PRODUCTS() throws Exception {
		mock = MockMvcBuilders.webAppContextSetup(aplicationContext).build();
		String JsonResponse = mock.perform(get("/api/products")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(
					status()
					.isOk())
			.andReturn()
			.getResponse()
			.getContentAsString();
		Products[] products = new ObjectMapper().readValue(JsonResponse, Products[].class);
		assertNotNull(products);
		System.out.println(JsonPath.parse(JsonResponse));
	}

	
	
}
