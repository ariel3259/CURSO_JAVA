package com.bootcamp.ApiStoreManagementII.Products;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
 
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootcamp.ApiStoreManagementII.Model.Products;
import com.bootcamp.ApiStoreManagementII.Repository.ProductsRepository;
import com.bootcamp.ApiStoreManagementII.Services.ProductsService;
 
@RunWith(SpringRunner.class)
@SpringBootTest
@MockBeans({
	@MockBean(ProductsRepository.class),
	@MockBean(ProductsService.class)
})
public class ProductsServiceTest {
 
	
   private static ProductsRepository repositoryMock;
 
    private static Products product1;
    private static Products product2;
 
    @Autowired ProductsService service;
 
    @BeforeAll
    public static void init() {
    	product1 = new Products(1, 3245, 25, "Banana", 30);
        product2 = new Products(2, 4356, 25, "Manzana", 30);
        when(repositoryMock.findAll()).thenReturn(Arrays.asList(product1, product2));
        when(repositoryMock.save(product1)).thenReturn(product1);
        when(repositoryMock.save(product2)).thenReturn(product2);
        when(repositoryMock.existsByIdAndState((long) 1, true)).thenReturn(true);
        when(repositoryMock.existsByIdAndState((long) 2, true)).thenReturn(false);
        when(repositoryMock.existsByCodeAndState(3245, true)).thenReturn(true);
        when(repositoryMock.existsByCodeAndState(3245, true)).thenReturn(false);
    }
 
    @Test
    public void getAllTest() {

        List<Products> allEmployees = service.getAll();
        assertNotNull(allEmployees);
        assertEquals(Arrays.asList(product1, product2), allEmployees);
    }
 
 
    @Test
    public void addProductTest() {

    	boolean result = service.save(product1);
    	boolean result2 = service.save(product2);
    	
        assertFalse(result);
        assertTrue(result2);
    }
 
    @Test
    public void updateProductTest() {

        boolean result = service.update(product1);
        boolean result2 = service.update(product2);
        
        assertTrue(result);
        assertFalse(result2);
    }
 
    @Test
    public void deleteEmployeeTest() {
  
        boolean result = service.delete(product1.getId());
        boolean result2 = service.delete(product2.getId());
 
        assertTrue(result);
        assertFalse(result2);
    }
 
}