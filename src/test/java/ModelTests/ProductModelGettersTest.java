/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTests;

import Model.ProductModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author joao8
 */
public class ProductModelGettersTest {
    
    private ProductModel pm;
    
    public ProductModelGettersTest() {
        this.pm = new ProductModel(01,10,"Celulares",1500f,"Redmi");
    }

    
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class ProductModel.
     */@Test
    public void testGetId() {
        assertEquals(01, pm.getId());
    }

    @org.junit.jupiter.api.Test
    public void testGetName() {
        assertEquals("Redmi", pm.getName());
    }
    /**
     * Test of getCategory method, of class ProductModel.
     */
    @org.junit.jupiter.api.Test
    public void testGetCategory() {
        assertEquals("Celulares", pm.getCategory());
    }
    
    /**
     * Test of getPrice method, of class ProductModel.
     */
    @org.junit.jupiter.api.Test
    public void testGetPrice() {
        assertEquals(1500f, pm.getPrice());
    }

    /**
     * Test of getAmount method, of class ProductModel.
     */
    @org.junit.jupiter.api.Test
    public void testGetAmount() {
        assertEquals(10, pm.getAmount());
    }
    
}
